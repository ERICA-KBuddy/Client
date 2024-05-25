package com.example.k_buddy.ui.mainPage.ui.market.request

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.k_buddy.R
import com.example.k_buddy.databinding.ActivityRequestTwoBinding


class RequestTwoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRequestTwoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRequestTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .add(binding.fragmentRequest.id,Request2Fragment())
            .commit()

        binding.next.setOnClickListener {
            startActivity(Intent(this@RequestTwoActivity,RequestThreeActivity::class.java))
        }
        binding.back.setOnClickListener {
            onBackPressed()
        }
    }
}