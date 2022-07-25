package com.example.androidsaas.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.androidsaas.R
import com.example.androidsaas.databinding.ActivityMainBinding
import com.example.androidsaas.manager.AuthManager

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)

//        when {
//            AuthManager.isAuthorized -> {
//                navController.navigate(R.id.mainFlowFragment)
////                navGraph.setStartDestination(R.id.mainFlowFragment)
//            }
//            !AuthManager.isAuthorized -> {
//                navController.navigate(R.id.loginFlowFragment)
////                navGraph.setStartDestination(R.id.loginFlowFragment)
//            }
//        }
        navController.graph = navGraph
    }
}