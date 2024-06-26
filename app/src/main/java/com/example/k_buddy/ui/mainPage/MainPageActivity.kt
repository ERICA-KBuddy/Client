package com.example.k_buddy.ui.mainPage

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.k_buddy.R
import com.example.k_buddy.databinding.ActivityMainPageBinding

class MainPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main_page)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val     appBarConfiguration = AppBarConfiguration(
            setOf(
                 R.id.navigation_market, R.id.navigation_home, R.id.navigation_mypage
            )
        )
        navView.setupWithNavController(navController)
    }
}