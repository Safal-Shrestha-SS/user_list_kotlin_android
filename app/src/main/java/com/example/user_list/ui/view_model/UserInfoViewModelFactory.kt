package com.example.user_list.ui.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.user_list.data.repository.UserInfoRepository

class UserInfoViewModelFactory(private val userInfoRepository: UserInfoRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserInfoViewModel(userInfoRepository) as T
    }

}
