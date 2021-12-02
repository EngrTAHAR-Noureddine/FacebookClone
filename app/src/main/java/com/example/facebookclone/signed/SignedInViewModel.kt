package com.example.facebookclone.signed

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.facebookclone.R
import com.example.facebookclone.databinding.SignedInFragmentBinding

class SignedInViewModel(private val binding: SignedInFragmentBinding, private val context : FragmentActivity, private val savedInstanceState: Bundle?) : ViewModel() {
    private var pref : SharedPreferences?
    private var _email = MutableLiveData<String?>()
    private var _password = MutableLiveData<String?>()

    init {
        this. pref = this.context?.getSharedPreferences("signIn", Context.MODE_PRIVATE)
        this._email.value = this.pref?.getString("email",null)
        this._password.value = this.pref?.getString("password",null)
    }
    fun onLogOut(){
        if(this._password.value != null && this._email.value!=null){
            with (this.pref?.edit()) {
                this?.putString("email",null)
                this?.putString("password",null)
            }

        }
        this.context.findNavController(R.id.myNavHostFragment)?.navigate(R.id.action_signedInFragment_to_signInFragment,this.savedInstanceState)
    }

}