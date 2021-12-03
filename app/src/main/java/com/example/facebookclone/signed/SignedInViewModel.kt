package com.example.facebookclone.signed

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.facebookclone.R
import com.example.facebookclone.databinding.SignedInFragmentBinding
import androidx.core.content.ContextCompat.startActivity

import com.example.facebookclone.MainActivity



import android.content.Intent



class SignedInViewModel(private val binding: SignedInFragmentBinding, private val context : FragmentActivity, private val savedInstanceState: Bundle?) : ViewModel() {
    private var pref : SharedPreferences?
    private var _email = MutableLiveData<String?>()
    private var _password = MutableLiveData<String?>()
    val email: LiveData<String?>
      get() = _email
    val password: LiveData<String?>
      get() = _password

    init {
        this. pref = this.context?.getSharedPreferences("signIn", Context.MODE_PRIVATE)
        this._email.value = this.pref?.getString("email",null)
        this._password.value = this.pref?.getString("password",null)

    }
    private fun saveData(email:String?, password :String?){
        val editor : SharedPreferences.Editor? = this.pref?.edit()
        editor?.apply{
            putString("email",email)
            putString("password",password)
        }?.apply()
    }

    fun onLogOut(){
        if(this._password.value != null && this._email.value!=null){
            saveData(null,null)
            this.context.findNavController(R.id.myNavHostFragment)?.navigate(R.id.action_signedInFragment_to_signInFragment,this.savedInstanceState)
            //val intent = Intent(this.context,MainActivity::class.java)
            //this.context.startActivity(intent)

        }
    }

}