package com.example.jirataskmvvm.utils

import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavDirections
import androidx.navigation.fragment.NavHostFragment

fun backButtonHandler(
    fragment: Fragment,
    fragmentActivity: FragmentActivity,
    action: NavDirections
) {
    val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            NavHostFragment.findNavController(fragment).navigate(action)
        }
    }
    fragmentActivity.onBackPressedDispatcher.addCallback(
        fragment, onBackPressedCallback
    )
}