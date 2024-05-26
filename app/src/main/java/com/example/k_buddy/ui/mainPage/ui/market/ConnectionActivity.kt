package com.example.k_buddy.ui.mainPage.ui.market

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.k_buddy.R
import com.example.k_buddy.databinding.ActivityConnectionBinding
import com.example.k_buddy.ui.mainPage.ui.market.request.RequestOneActivity
import com.google.android.material.tabs.TabLayoutMediator

class ConnectionActivity : AppCompatActivity() {
    private lateinit var binding : ActivityConnectionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConnectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Info"
                1 -> "Review"
                2 -> "Photo"
                else -> null
            }
        }.attach()
        binding.back.setOnClickListener {
            onBackPressed()
        }

        binding.requestButton.setOnClickListener {
            startActivity(Intent(this@ConnectionActivity,RequestOneActivity::class.java))
            finish()
        }
    }
}