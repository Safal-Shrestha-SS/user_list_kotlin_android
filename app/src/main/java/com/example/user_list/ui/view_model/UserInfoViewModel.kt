package com.example.user_list.ui.view_model

import android.app.Application
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.BaseObservable
import androidx.databinding.ObservableField
import androidx.lifecycle.*
import androidx.navigation.NavArgs
import com.example.user_list.data.db.dao.UserInfoDao
import com.example.user_list.data.db.dao.UserInfoDatabase
import com.example.user_list.data.db.entity.UserInfo
import com.example.user_list.data.repository.UserInfoRepository
import com.example.user_list.ui.fragment.AddUserInfoFragmentArgs
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class UserInfoViewModel(private val userInfoRepository: UserInfoRepository) : ViewModel() {


    var userInfoField: ObservableField<UserInfo> =
        ObservableField(UserInfo(user_name = "", user_phone = ""))
    var showFragment = MutableLiveData<Boolean>(false)

    fun upsert(item: UserInfo) {
        viewModelScope.launch {
            userInfoRepository.upsert(item)
        }
    }

    fun delete(item: UserInfo) {
        viewModelScope.launch {
            userInfoRepository.delete(item)
        }
    }

    fun getAllUserInfo(): LiveData<List<UserInfo>> =
        userInfoRepository.getAllUserInfo().asLiveData()

    fun addEditField(view: View) {
        //to do validate if userInfoField item is null or empty\
        if (userInfoField.get()?.user_name.isNullOrEmpty()
                .not() && userInfoField.get()?.user_phone.isNullOrEmpty().not()
        ) {
            Log.d("user_info_field", "user info field :${userInfoField.get().toString()}")
            showFragment.value = false
            upsert(userInfoField.get()!!)
        } else {
            val myToast = Toast.makeText(view.context,"Enter Name and Phone",Toast.LENGTH_LONG)
            myToast.show()
        }
    }

    fun setArgs(args: AddUserInfoFragmentArgs?) {
        args?.let {
            if (it.userName.isNullOrEmpty().not() && it.phoneNo.isNullOrEmpty()
                    .not()
            ) userInfoField.set(
                UserInfo(it.id, it.userName, it.phoneNo)
            )
        }
        showFragment.value = true
    }
}



