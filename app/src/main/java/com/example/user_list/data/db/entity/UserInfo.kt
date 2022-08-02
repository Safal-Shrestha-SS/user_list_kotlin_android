package com.example.user_list.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_info_table")
data class UserInfo(
    @PrimaryKey(autoGenerate = true)  var id: Int=0,
    @ColumnInfo(name = "user_name")
    var user_name: String?,
    var user_phone: String?,
){

    override fun toString(): String {
      return " user_name   $user_name  user_phone: ${user_phone}"
    }

}
