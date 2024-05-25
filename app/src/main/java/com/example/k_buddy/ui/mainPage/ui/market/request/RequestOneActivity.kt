package com.example.k_buddy.ui.mainPage.ui.market.request

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.k_buddy.R

import com.example.k_buddy.databinding.ActivityRequestOneBinding

class RequestOneActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRequestOneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRequestOneBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .add(binding.fragmentRequest.id,Request1Fragment())
            .commit()
        binding.next.setOnClickListener {
            startActivity(Intent(this@RequestOneActivity,RequestTwoActivity::class.java))
        }

    }
}

