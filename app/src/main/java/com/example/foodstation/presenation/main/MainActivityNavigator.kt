package com.example.foodstation.presenation.main

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager
import com.example.foodstation.common.utils.DummyNavigator
import com.example.foodstation.common.utils.FragmentTransactionHelper
import com.example.foodstation.presenation.home.HomeFragment
import com.example.foodstation.presenation.home.HomeNavigator

class MainActivityNavigator constructor(
    @IdRes private val containerId: Int,
    private val fragmentManager: FragmentManager
): HomeNavigator{


    /*---------------------------------Main Activity-------------------------------------*/

    private fun popAllFragments() {
        FragmentTransactionHelper.popAllFragments(fragmentManager)
    }

    private fun dismissAllDialogFragments() {
        FragmentTransactionHelper.dismissAllDialogs(fragmentManager)
    }

    fun navigateToHomeScreen() {
        popAllFragments()
        FragmentTransactionHelper.replaceFragment(
            fragmentManager,
            HomeFragment.newInstance(),
            containerId, addToBackStack = true
        )
    }
}