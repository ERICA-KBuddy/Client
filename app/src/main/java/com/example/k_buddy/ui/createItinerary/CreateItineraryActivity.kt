package com.example.k_buddy.ui.createItinerary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.k_buddy.databinding.ActivityCreateItineraryBinding

class CreateItineraryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateItineraryBinding
    private lateinit var intent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateItineraryBinding.inflate(layoutInflater)
        setContentView(binding.root)


        /*
            뒤로가기 버튼 클릭
         */
        binding.btnSaveExit.setOnClickListener {
            finish()
        }
        /*
        여행기 작성 버튼 클릭
     */
        binding.nextButton.setOnClickListener {
            intent = Intent(this, ActivityCreateItineraryBinding::class.java)
            startActivity(intent)
            finish()
        }
    }
}