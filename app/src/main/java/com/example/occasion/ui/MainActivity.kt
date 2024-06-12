package com.example.occasion.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.occasion.R
import com.example.occasion.databinding.ActivityMainBinding
import android.view.View
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar o Firebase
        Firebase.database.setPersistenceEnabled(true)

        val navHostFragment = supportFragmentManager.findFragmentById(binding.navHostFragment.id) as NavHostFragment
        iniNavigation()
    }

    private fun iniNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.btnv, navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.splashFragment -> binding.btnv.visibility = View.GONE
                R.id.loginFragment -> binding.btnv.visibility = View.GONE
                R.id.registerFragment -> binding.btnv.visibility = View.GONE
                else -> binding.btnv.visibility = View.VISIBLE
            }
        }
    }
}
