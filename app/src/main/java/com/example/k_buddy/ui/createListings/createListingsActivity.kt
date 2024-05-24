package com.example.k_buddy.ui.createListings

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.k_buddy.databinding.ActivityCreateListingsBinding
import com.example.k_buddy.ui.createItinerary.createItineraryActivity
import com.example.k_buddy.ui.mainPage.MainPageActivity

class createListingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateListingsBinding
    private lateinit var intent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateListingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*
            뒤로가기 버튼 클릭
         */
        binding.buttonBack.setOnClickListener {
            finish()
        }
        /*
            여행기 작성 버튼 클릭
         */
        binding.buttonCreateItinerary.setOnClickListener {
            intent = Intent(this, createItineraryActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}