package com.shifthackz.testamconsoft.presentation.item

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.shifthackz.testamconsoft.usecases.repository.database.entity.UserEntity
import kotlinx.android.synthetic.main.item_user.view.*

class UserViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

    private var userEntity: UserEntity? = null
    private var listener: IUserItemClickListener<UserEntity>? = null
    private val itemDetail = View.OnClickListener { listener!!.openDetail(this!!.userEntity!!) }

    fun bind(userEntity: UserEntity, listener: IUserItemClickListener<UserEntity>) {
        this.userEntity = userEntity
        this.listener = listener
        initItem()
    }

    private fun initItem() {
        view.tvRvUserName.text = userEntity!!.name
        view.tvRvUserMail.text = userEntity!!.email
        view.setOnClickListener(itemDetail)
    }
}