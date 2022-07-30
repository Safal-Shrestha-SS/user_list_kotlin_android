package com.example.user_list.data.db.dao

import androidx.room.*
import com.example.user_list.data.db.entity.UserInfo
import kotlinx.coroutines.flow.Flow

@Dao
interface UserInfoDao {

    @Insert( onConflict = OnConflictStrategy.REPLACE )
    suspend fun upsert(item: UserInfo)

    @Delete
    suspend fun delete(item: UserInfo)

    @Query("SELECT * FROM user_info_table")
    fun getAllUserInfo(): Flow<List<UserInfo>>

}