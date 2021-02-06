package com.example.foodstation.presenation.main

import android.os.Bundle
import androidx.activity.viewModels

import com.example.foodstation.R
import com.example.foodstation.common.base.BaseActivity
import com.example.foodstation.databinding.ActivityMainBinding

class MainActivity :
    BaseActivity<ActivityMainBinding, MainActivityNavigator>(R.layout.activity_main) {

    private val viewModel: MainActivityViewModel by viewModels { viewModelFactory }
    private var mainActivityNavigator: MainActivityNavigator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mainActivityNavigator =
            MainActivityNavigator(
                getFragmentContainerID(),
                supportFragmentManager)

        mainActivityNavigator?.navigateToHomeScreen()

        viewModel.getCompanyName()


    }

    override fun getFragmentNavigator(): MainActivityNavigator? = mainActivityNavigator

    private fun getFragmentContainerID(): Int {
        return viewBinding.fragmentContainer.id
    }


    override fun onDestroy() {
        super.onDestroy()
        mainActivityNavigator = null
    }



}