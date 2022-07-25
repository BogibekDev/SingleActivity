package com.example.androidsaas.fragment.auth.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.androidsaas.R
import com.example.androidsaas.databinding.FragmentLoginBinding
import com.example.androidsaas.extension.activityNavController
import com.example.androidsaas.extension.navigateSafely
import com.example.androidsaas.fragment.BaseFlowFragment
import com.example.androidsaas.manager.AuthManager


class LoginFragment : Fragment(R.layout.fragment_login) {
    private val binding by viewBinding(FragmentLoginBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        binding.bSignin.setOnClickListener {
            AuthManager.isAuthorized = true
            activityNavController().navigateSafely(R.id.action_global_mainFlowFragment)
        }
        binding.tvSignup.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }
    }
}