package com.example.user_list.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.user_list.R
import com.example.user_list.UserInfoApplication
import com.example.user_list.ui.view_model.UserInfoViewModel
import com.example.user_list.ui.view_model.UserInfoViewModelFactory

class AddUserInfoFragment : Fragment() {

    companion object {
        fun newInstance() = AddUserInfoFragment()
    }

    private lateinit var viewModel: UserInfoViewModel
    private lateinit var viewModelFactory: UserInfoViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_user_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelFactory = UserInfoViewModelFactory(UserInfoApplication().userInfoRepository)
        viewModel = ViewModelProvider(this,viewModelFactory)[UserInfoViewModel::class.java]
        // TODO: Use the ViewModel

    }

}