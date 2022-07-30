package com.example.user_list.data.repository

import com.example.user_list.data.db.dao.UserInfoDao
import com.example.user_list.data.db.dao.UserInfoDatabase
import com.example.user_list.data.db.entity.UserInfo

class UserInfoRepository(private val userInfoDao: UserInfoDao) {


    suspend fun upsert(item:UserInfo)= userInfoDao.upsert(item)

    suspend fun delete(item: UserInfo)= userInfoDao.delete(item)

    fun getAllUserInfo()= userInfoDao.getAllUserInfo()

}