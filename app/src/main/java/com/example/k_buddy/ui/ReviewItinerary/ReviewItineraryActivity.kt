package com.example.k_buddy.ui.ReviewItinerary

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.k_buddy.R
import com.example.k_buddy.databinding.ActivityReviewItineraryBinding
import com.example.k_buddy.ui.SubmitItinerary.SubmitItineraryActivity


class ReviewItineraryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReviewItineraryBinding
    private lateinit var intent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReviewItineraryBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.nextButton.setOnClickListener {
            intent = Intent(this, SubmitItineraryActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnSaveExit.setOnClickListener {
            finish()
        }

        var sectionIsVisible = false
        binding.itineraryBox.setOnClickListener{
            sectionIsVisible = !sectionIsVisible
            binding.itinerarySection.visibility = if (sectionIsVisible) View.VISIBLE else View.GONE
        }
    }
}