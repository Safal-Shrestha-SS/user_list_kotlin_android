package com.example.user_list

import android.app.Application
import com.example.user_list.data.db.dao.UserInfoDatabase
import com.example.user_list.data.repository.UserInfoRepository

class UserInfoApplication:Application() {

    private val database: UserInfoDatabase by lazy { UserInfoDatabase(this) }

    val userInfoRepository: UserInfoRepository by lazy { UserInfoRepository(database.getUserInfoDao()) }

}