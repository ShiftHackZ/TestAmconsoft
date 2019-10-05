package com.shifthackz.testamconsoft.presentation.activities.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider
import com.shifthackz.testamconsoft.R
import com.shifthackz.testamconsoft.di.component.ViewModelComponent
import com.shifthackz.testamconsoft.presentation.activities.main.MainActivity
import com.shifthackz.testamconsoft.presentation.base.BaseActivity
import com.shifthackz.testamconsoft.utils.Constants
import kotlinx.android.synthetic.main.activity_auth.*

class AuthActivity : BaseActivity() {

    companion object {
        @JvmStatic
        fun newInstance(context: Context): Intent {
            val intent = Intent(context, AuthActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            return intent
        }
    }

    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        initGoogleSignInClient()
        initUI()
    }

    override fun injectDependency(component: ViewModelComponent) { }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == Constants.RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account!!)
            }
            catch (ex: ApiException) {
                Log.w(Constants.TAG_ERROR, ex?.message)
            }
        }
    }

    private fun initUI() {
        btnGoogleSignIn.setOnClickListener {
            doSignIn()
        }
    }

    private fun initGoogleSignInClient() {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)
    }

    private fun doSignIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, Constants.RC_SIGN_IN)
    }

    private fun doNavigationToMain() {
        startActivity(MainActivity.newInstance(this))
        finish()
    }

    private fun showMessage(message: String) {
        Toast.makeText(this,message, Toast.LENGTH_LONG).show()
    }

    private fun firebaseAuthWithGoogle(acct: GoogleSignInAccount) {
        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        getFirebaseAuth().signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    doNavigationToMain()
                } else {
                    Log.w(Constants.TAG_ERROR, task.exception)
                    showMessage(getString(R.string.error_auth_fail))
                }
            }
    }
}
