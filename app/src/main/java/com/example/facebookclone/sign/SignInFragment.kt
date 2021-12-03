package com.example.facebookclone.sign


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.facebookclone.R
import com.example.facebookclone.databinding.SignInFragmentBinding

class SignInFragment : Fragment() {


    private lateinit var binding: SignInFragmentBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        this.binding = DataBindingUtil.inflate(
            inflater,
            R.layout.sign_in_fragment,
            container,
            false
        )
        activity?.let{
            val factory = SignInFactory(this.binding, it,savedInstanceState)
            this.binding.signIn = ViewModelProviders.of(this, factory)[SignInViewModel::class.java]
        }

        this.binding.lifecycleOwner = this
        return this.binding.root
    }





}