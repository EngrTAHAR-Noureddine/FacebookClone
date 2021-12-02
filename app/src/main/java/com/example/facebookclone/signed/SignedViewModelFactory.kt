package com.example.facebookclone.signed

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.facebookclone.databinding.SignedInFragmentBinding

class SignedViewModelFactory(private val binding: SignedInFragmentBinding, private val context : FragmentActivity, private val savedInstanceState: Bundle?):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

            if (modelClass.isAssignableFrom(SignedInViewModel::class.java)) {
                return SignedInViewModel(this.binding,this.context,this.savedInstanceState) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")

    }

}