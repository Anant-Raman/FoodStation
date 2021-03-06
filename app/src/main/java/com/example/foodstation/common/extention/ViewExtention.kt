package com.cegidflow.android.common.extensions

import android.app.Activity
import android.os.Build
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import com.example.foodstation.R
import com.example.foodstation.common.base.BaseFragment

fun View.hideKeyboard() {
    context?.let {
        val inputMethodManager =
            it.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(this.windowToken, 0)
    }
}

fun View.isVisible(): Boolean {
    return visibility == View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

@Suppress("DEPRECATION")
fun View.changeStatusBarColor(
    activity: Activity,
    color: BaseFragment.StatusBarColor,
    isFullScreen: Boolean = false
) {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
        // on devices below API 23 set color to black
        activity.window.statusBarColor = ContextCompat.getColor(activity, R.color.black)
    } else {
        activity.window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        activity.window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        post {
            systemUiVisibility = 0
            if (isFullScreen) {
                systemUiVisibility =
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            } else if (color.isLightColor) {
                systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
            activity.window.statusBarColor = ContextCompat.getColor(activity, color.color)
        }
    }
}