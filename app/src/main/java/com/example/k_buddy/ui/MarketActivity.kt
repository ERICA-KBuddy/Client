package com.example.k_buddy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.k_buddy.R
import com.example.k_buddy.databinding.ActivityMarketBinding

class MarketActivity : AppCompatActivity() {
    private lateinit var bindig : ActivityMarketBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindig = ActivityMarketBinding.inflate(layoutInflater)
        setContentView(bindig.root)
    }
}