package com.example.k_buddy.ui.profileEdit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.k_buddy.databinding.ActivityEditListingsBinding
import com.example.k_buddy.ui.ReviewItinerary.ReviewItineraryActivity


class EditListingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditListingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditListingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.nextButton.setOnClickListener {
//            val intent = Intent(this, ReviewItineraryActivity::class.java)
//            startActivity(intent)
//            finish()
//        }

        binding.btnSaveExit.setOnClickListener {
            finish()
        }
    }

}