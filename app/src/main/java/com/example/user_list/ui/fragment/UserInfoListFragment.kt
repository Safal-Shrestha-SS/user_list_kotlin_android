package com.example.user_list.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.user_list.R
import com.example.user_list.UserInfoApplication
import com.example.user_list.data.db.entity.UserInfo
import com.example.user_list.databinding.FragmentUserInfoListBinding
import com.example.user_list.ui.adapter.UserInfoAdapter
import com.example.user_list.ui.view_model.UserInfoViewModel
import com.example.user_list.ui.view_model.UserInfoViewModelFactory

class UserInfoListFragment : Fragment(), UserInfoAdapter.OnTileClicked {
    private lateinit var viewModelFactory: UserInfoViewModelFactory
    private lateinit var  adapter: UserInfoAdapter
    private lateinit var  viewModel: UserInfoViewModel
    private lateinit var  binding: FragmentUserInfoListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_user_info_list,container,false)
        viewModelFactory = UserInfoViewModelFactory(UserInfoApplication(requireContext()).userInfoRepository)
        viewModel = ViewModelProvider(this, viewModelFactory)[UserInfoViewModel::class.java]
        adapter = UserInfoAdapter(this)
        binding.userInfoRV.adapter = adapter
        viewModel.getAllUserInfo().observe(viewLifecycleOwner) { adapter.refreshDataList(it) }
        binding.addUserInfo.setOnClickListener {
            val action = UserInfoListFragmentDirections.navigateToEdit(null,null,0)
            Navigation.findNavController(binding.root).navigate(action)
        }
        return binding.root
    }

    override fun onEditClicked(userInfo: UserInfo) {
        val action = UserInfoListFragmentDirections.navigateToEdit(userInfo.user_name,userInfo.user_phone.toString(),userInfo.id)
        Navigation.findNavController(binding.root).navigate(action)
    }

    override fun onDeleteClicked(item: UserInfo) {
        viewModel.delete(item)

    }
}