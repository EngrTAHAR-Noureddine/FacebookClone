package com.example.facebookclone.sign

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.facebookclone.databinding.SignInFragmentBinding

class SignInFactory(private val binding: SignInFragmentBinding, private val context: FragmentActivity, private val savedInstanceState:Bundle?):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SignInViewModel::class.java)) {
            return SignInViewModel(this.binding , this.context, this.savedInstanceState) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}