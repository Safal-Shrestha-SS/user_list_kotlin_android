package com.example.user_list.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.user_list.R
import com.example.user_list.UserInfoApplication
import com.example.user_list.databinding.ActivityUserInfoBinding
import com.example.user_list.ui.adapter.UserInfoAdapter
import com.example.user_list.ui.view_model.UserInfoViewModel
import com.example.user_list.ui.view_model.UserInfoViewModelFactory

class UserInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserInfoBinding
    private lateinit var viewModelFactory: UserInfoViewModelFactory
    private lateinit var viewModel: UserInfoViewModel
    private lateinit var adapter: UserInfoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_info)
        viewModelFactory = UserInfoViewModelFactory(UserInfoApplication().userInfoRepository)
        viewModel = ViewModelProvider(this, viewModelFactory)[UserInfoViewModel::class.java]
        adapter = UserInfoAdapter()
        binding.userInfoRV.adapter = adapter
        viewModel.getAllUserInfo().observe(this) { adapter.refreshDataList(it) }
    }

}