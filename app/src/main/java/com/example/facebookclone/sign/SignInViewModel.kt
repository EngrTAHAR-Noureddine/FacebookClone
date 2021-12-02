package com.example.facebookclone.sign

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.facebookclone.R
import com.example.facebookclone.databinding.SignInFragmentBinding

class SignInViewModel(private val binding:SignInFragmentBinding, private val context : FragmentActivity, private val savedInstanceState: Bundle?): ViewModel() {

    private var pref : SharedPreferences?
    private var _email = MutableLiveData<String?>()
    //val email: LiveData<String?>
      //  get() = _email
    private var _password = MutableLiveData<String?>()
    //val password: LiveData<String?>
      //  get() = _password


    init {
        this. pref = this.context?.getSharedPreferences("signIn", Context.MODE_PRIVATE)
        this._email.value = this.pref?.getString("email",null)
        this._password.value = this.pref?.getString("password",null)
        this.goToSignedPage()


    }

    private fun goToSignedPage(){
        if(this._password.value != null && this._email.value!=null){
            this.context.findNavController(R.id.myNavHostFragment)?.navigate(R.id.action_signInFragment_to_signedInFragment,this.savedInstanceState)
        }
    }

    fun onClickSignIn(){
        this._email.value = if(this.binding.emailInput == null) null else this.binding.emailInput.toString()
        this._password.value = if(this.binding.passwordInput == null) null else this.binding.passwordInput.toString()

        if(this._email.value!=null && this._password!= null ){
            with (this.pref?.edit()) {
                this?.putString("email",_email.value.toString())
                this?.putString("password",_password.value.toString())
            }
            this.goToSignedPage()
        }


    }



}