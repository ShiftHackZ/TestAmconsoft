package com.shifthackz.testamconsoft.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.shifthackz.testamconsoft.R
import com.shifthackz.testamconsoft.presentation.base.BaseAdapter
import com.shifthackz.testamconsoft.presentation.item.IUserItemClickListener
import com.shifthackz.testamconsoft.presentation.item.UserViewHolder
import com.shifthackz.testamconsoft.usecases.repository.database.entity.UserEntity

class UserAdapter(private val context: Context, private val users: List<UserEntity>, private val listener: IUserItemClickListener<UserEntity>):
BaseAdapter<UserViewHolder, UserEntity, IUserItemClickListener<UserEntity>>(users as MutableList<UserEntity>, listener) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(context).inflate(R.layout.item_user, parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.bind(users[position], listener)
    }

    override fun getItemCount(): Int {
        return users.size
    }

}