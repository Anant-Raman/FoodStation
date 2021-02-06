package com.example.foodstation.presenation.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.foodstation.R
import com.example.foodstation.common.base.BaseFragment
import com.example.foodstation.databinding.FragmentHomeBinding

class HomeFragment :
    BaseFragment<FragmentHomeBinding, HomeNavigator>(R.layout.fragment_home) {

    private val homeViewModel: HomeViewModel by viewModels { viewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.getCompanyName()
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}