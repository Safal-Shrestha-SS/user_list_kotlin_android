package com.example.user_list.ui.view_model

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.user_list.data.db.dao.UserInfoDao
import com.example.user_list.data.db.dao.UserInfoDatabase
import com.example.user_list.data.db.entity.UserInfo
import com.example.user_list.data.repository.UserInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class UserInfoViewModel(private val userInfoRepository: UserInfoRepository ) : ViewModel() {

    fun upsert(item: UserInfo) {
        viewModelScope.launch {
            userInfoRepository.upsert(item)
        }
    }

    fun delete(item:UserInfo) {
        viewModelScope.launch {
            userInfoRepository.delete(item)
        }
    }

    fun getAllUserInfo(): LiveData<List<UserInfo>> = userInfoRepository.getAllUserInfo().asLiveData()

}