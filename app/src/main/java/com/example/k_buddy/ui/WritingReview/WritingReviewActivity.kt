package com.example.k_buddy.ui.WritingReview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.k_buddy.databinding.ActivityWritingReviewBinding
import com.example.k_buddy.ui.mainPage.MainPageActivity

class WritingReviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWritingReviewBinding
    private lateinit var intent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWritingReviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonPost.setOnClickListener {
            intent = Intent(this, MainPageActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.buttonBack.setOnClickListener {
            intent = Intent(this, MainPageActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}