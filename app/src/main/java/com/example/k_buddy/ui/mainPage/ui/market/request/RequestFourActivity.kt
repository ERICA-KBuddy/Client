package com.example.k_buddy.ui.mainPage.ui.market.request

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.k_buddy.databinding.ActivityRequestFourBinding
import com.example.k_buddy.ui.mainPage.MainPageActivity

class RequestFourActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRequestFourBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRequestFourBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn.setOnClickListener {
            startActivity(Intent(this@RequestFourActivity,MainPageActivity::class.java))
            finish()
        }
    }
}