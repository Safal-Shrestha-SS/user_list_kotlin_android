package com.example.user_list.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_info_table")
data class UserInfo(
    @PrimaryKey(autoGenerate = true)  var id: Int,
    @ColumnInfo(name = "user_name")
    var user_name: String,
    var user_phone: Long,
)
