package com.example.foodstation

import android.app.Application
import com.example.foodstation.common.di.DependencyProvider

class BaseApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        DependencyProvider.inject(this)
    }
}