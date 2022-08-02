package com.example.user_list.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.user_list.R
import com.example.user_list.UserInfoApplication
import com.example.user_list.data.db.entity.UserInfo
import com.example.user_list.databinding.FragmentAddUserInfoBinding
import com.example.user_list.ui.view_model.UserInfoViewModel
import com.example.user_list.ui.view_model.UserInfoViewModelFactory

class AddUserInfoFragment : Fragment() {

    companion object {
        fun newInstance() = AddUserInfoFragment()
    }

    private lateinit var binding: FragmentAddUserInfoBinding
    private lateinit var viewModel: UserInfoViewModel
    private lateinit var viewModelFactory: UserInfoViewModelFactory
    private val args: AddUserInfoFragmentArgs? by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_add_user_info, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelFactory =
            UserInfoViewModelFactory(UserInfoApplication(view.context).userInfoRepository)
        viewModel = ViewModelProvider(this, viewModelFactory)[UserInfoViewModel::class.java]
        binding.item= viewModel


        //todo store args in viewmodel
        viewModel.setArgs(args)
        viewModel.showFragment.observe(viewLifecycleOwner){
            if (it==false) Navigation.findNavController(binding.root).popBackStack()
        }
//        binding.buttonAddUserInfo.setOnClickListener {
//            Log.d("buttonAdd","I am clicked")
//            Navigation.findNavController(binding.root).popBackStack() }
//        binding.buttonAddUserInfo.setOnClickListener {
//            Log.d("AddUserInfo", userName.toString())
//            viewModel.setUserInfoField(UserInfo())
////            if (args?.userName != null) {
////                viewModel.upsert(
////                    UserInfo(
////                        id = args?.id!!,
////                        user_name = userName.toString(),
////                        phoneNo.toString()
////                    )
////                )
////            } else {
////                viewModel.upsert(
////                    UserInfo(
////                        user_name = userName.toString(),
////                        user_phone = phoneNo.toString()
////                    )
////                )
////
////            }
////            Navigation.findNavController(binding.root).popBackStack()
//        }


    }

}