package com.example.user_list.data.db.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.user_list.data.db.entity.UserInfo


@Database(
    entities = [UserInfo::class],
    version = 1,
)

abstract class UserInfoDatabase : RoomDatabase() {

    abstract fun getUserInfoDao(): UserInfoDao

    companion object {
        @Volatile
        private var instance: UserInfoDatabase? = null
        operator fun invoke(context: Context) = instance ?: synchronized(this) {
            instance ?: Room.databaseBuilder(
                context.applicationContext,
                UserInfoDatabase::class.java,
                "AppDB.db"
            ).build()
        }
    }

}