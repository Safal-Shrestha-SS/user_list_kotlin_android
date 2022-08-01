package com.example.user_list

import android.app.Application
import android.content.Context
import com.example.user_list.data.db.dao.UserInfoDatabase
import com.example.user_list.data.repository.UserInfoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class UserInfoApplication(context:Context) {

    private val applicationScope = CoroutineScope(SupervisorJob())

    private val database: UserInfoDatabase by lazy { UserInfoDatabase(context,applicationScope) }

    val userInfoRepository: UserInfoRepository by lazy { UserInfoRepository(database.getUserInfoDao()) }

}