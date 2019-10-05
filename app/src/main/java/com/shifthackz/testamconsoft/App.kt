package com.shifthackz.testamconsoft

import android.app.Application
import androidx.room.Room
import com.google.firebase.auth.FirebaseAuth
import com.shifthackz.testamconsoft.di.component.*
import com.shifthackz.testamconsoft.di.module.*
import com.shifthackz.testamconsoft.usecases.repository.database.AppDatabase

class App: Application() {

    private var viewModelComponent: ViewModelComponent? = null
    private var database: AppDatabase? = null
    private var firebaseAuth: FirebaseAuth? = null

    override fun onCreate() {
        super.onCreate()
        initFirebaseAuth()
        initRoom()
        initDagger()
    }

    fun getViewModelComponent(): ViewModelComponent {
        return this!!.viewModelComponent!!
    }

    fun getFirebaseAuth(): FirebaseAuth {
        return this!!.firebaseAuth!!
    }

    private fun initRoom() {
        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .allowMainThreadQueries()
            .build()
    }

    private fun initDagger() {
        val apiComponent = DaggerApiComponent.builder()
            .apiModule(ApiModule())
            .build()

        val databaseComponent = DaggerDatabaseComponent.builder()
            .databaseModule(DatabaseModule(this!!.database!!))
            .build()

        val repositoryComponent = DaggerRepositoryComponent.builder()
            .apiComponent(apiComponent)
            .databaseComponent(databaseComponent)
            .repositoryModule(RepositoryModule())
            .build()

        val interactorComponent = DaggerInteractorComponent.builder()
            .repositoryComponent(repositoryComponent)
            .interactorModule(InteractorModule())
            .build()

        viewModelComponent = DaggerViewModelComponent.builder()
            .interactorComponent(interactorComponent)
            .viewModelModule(ViewModelModule(this))
            .build()
    }

    private fun initFirebaseAuth() {
        firebaseAuth = FirebaseAuth.getInstance()
    }
}