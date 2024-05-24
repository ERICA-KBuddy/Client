

package com.example.k_buddy.ui.request

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.k_buddy.R
import com.example.k_buddy.databinding.ActivityRequest1Binding

class Request1Activity : AppCompatActivity() {
    private lateinit var binding : ActivityRequest1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRequest1Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}