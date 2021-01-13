package com.example.foodstation.common.di

import android.content.Context

/**
 * Provides Constructor dependency to all providers which in turn provides constructor dependencies
 * to all sources like api sources, various other sources, repository, usecases, viewmodels i.e.
 * it provides dependency to all levels of MVVM
 **/
object DependencyProvider {
    private lateinit var applicationContext: Context

    fun inject(context: Context) {
        applicationContext = context
    }
}