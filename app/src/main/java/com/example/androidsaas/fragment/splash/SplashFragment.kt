package com.example.androidsaas.fragment.splash

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.androidsaas.R
import com.example.androidsaas.manager.AuthManager


class SplashFragment : Fragment(R.layout.fragment_splash) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        object : CountDownTimer(2500, 1000) {
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {
                if (AuthManager.isAuthorized) {
                    findNavController().navigate(R.id.mainFlowFragment)
                } else {
                    findNavController().navigate(R.id.loginFlowFragment)
                }
            }
        }.start()


    }

}