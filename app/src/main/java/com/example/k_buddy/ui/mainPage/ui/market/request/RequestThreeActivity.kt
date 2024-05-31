package com.example.k_buddy.ui.mainPage.ui.market.request

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.k_buddy.R
import com.example.k_buddy.databinding.ActivityRequestThreeBinding
import com.example.k_buddy.databinding.ActivityRequestTwoBinding

class RequestThreeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRequestThreeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRequestThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .add(binding.fragmentRequest.id,Request3Fragment())
            .commit()
        binding.next.setOnClickListener {
            startActivity(Intent(this@RequestThreeActivity,RequestFourActivity::class.java))
        }
        binding.back.setOnClickListener {
            onBackPressed()
        }
    }
}