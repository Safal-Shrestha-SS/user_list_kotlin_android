package com.example.user_list.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.user_list.R
import com.example.user_list.data.db.entity.UserInfo
import com.example.user_list.databinding.UserInfoTileBinding

class UserInfoAdapter(private val dataset: MutableList<UserInfo> = ArrayList()) :
    RecyclerView.Adapter<UserInfoAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(private val itemBinding: UserInfoTileBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(userInfo: UserInfo) {
            with(itemBinding) {
                itemBinding.userName.text = userInfo.user_name
                itemBinding.userPhoneNo.text = userInfo.user_phone.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayOut = DataBindingUtil.inflate<UserInfoTileBinding>(
            LayoutInflater.from(parent.context),
            R.layout.user_info_tile,
            parent,
            false
        )
        return ItemViewHolder(adapterLayOut)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun refreshDataList(list: List<UserInfo>) {
        dataset.clear()
        dataset.addAll(list)
        notifyDataSetChanged()
    }

}