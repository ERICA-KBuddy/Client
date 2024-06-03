package com.example.k_buddy.ui.SubmitItinerary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.k_buddy.R
import com.example.k_buddy.databinding.ActivitySubmitItineraryBinding
import com.example.k_buddy.ui.WritingReview.WritingReviewActivity
import com.example.k_buddy.ui.mainPage.MainPageActivity

class SubmitItineraryActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubmitItineraryBinding
    private lateinit var intent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubmitItineraryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSaveExit.setOnClickListener {
            finish()
        }

        binding.submitButton.setOnClickListener {
            intent = Intent(this, WritingReviewActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}