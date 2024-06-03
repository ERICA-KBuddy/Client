package com.example.k_buddy.ui.OrderedItinerary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.k_buddy.R
import com.example.k_buddy.databinding.ActivityOrderedItineraryBinding
import com.example.k_buddy.ui.WritingReview.WritingReviewActivity
import com.example.k_buddy.ui.mainPage.MainPageActivity

class OrderedItineraryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOrderedItineraryBinding
    private lateinit var intent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderedItineraryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.nextButton.setOnClickListener {
            intent = Intent(this, WritingReviewActivity::class.java)
            startActivity(intent)
            finish()
        }

        var sectionIsVisible = false
        binding.itineraryBox.setOnClickListener{
            sectionIsVisible = !sectionIsVisible
            binding.itinerarySection.visibility = if (sectionIsVisible) View.VISIBLE else View.GONE
        }
    }
}