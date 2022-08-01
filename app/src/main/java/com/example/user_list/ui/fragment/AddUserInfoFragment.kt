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
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_add_user_info,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelFactory = UserInfoViewModelFactory(UserInfoApplication(view.context).userInfoRepository)
        viewModel = ViewModelProvider(this,viewModelFactory)[UserInfoViewModel::class.java]
        args?.let {
            binding.editName.setText(it.userName)
            binding.editPhoneNo.setText(it.phoneNo)
        }
        val userName= binding.editName.text
        val phoneNo= binding.editPhoneNo.text
        binding.buttonAddUserInfo.setOnClickListener {
            Log.d("AddUserInfo",userName.toString())
            if(args?.userName!= null){
                viewModel.upsert(UserInfo(id=args?.id!!, user_name = userName.toString(), phoneNo.toString().toLong()))
            }
            else{
                viewModel.upsert(UserInfo(user_name = userName.toString(), user_phone = phoneNo.toString().toLong()))

            }
            Navigation.findNavController(binding.root).popBackStack()
        }


    }

}