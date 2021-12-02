package com.example.facebookclone.signed

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.facebookclone.R
import com.example.facebookclone.databinding.SignInFragmentBinding
import com.example.facebookclone.databinding.SignedInFragmentBinding
import com.example.facebookclone.sign.SignInFactory
import com.example.facebookclone.sign.SignInViewModel

class SignedInFragment : Fragment() {


    private lateinit var binding: SignedInFragmentBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        this.binding = DataBindingUtil.inflate(
            inflater,
            R.layout.signed_in_fragment,
            container,
            false
        )
        activity?.let{
            val factory = activity?.let { it1 -> SignedViewModelFactory(this.binding, it1,savedInstanceState) }
            this.binding.signed = ViewModelProviders.of(this, factory)[SignedInViewModel::class.java]
        }

        this.binding.lifecycleOwner = this








        return this.binding.root
    }



}