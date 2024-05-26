package com.example.k_buddy.ui.mainPage.ui.market.request

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.k_buddy.databinding.FragmentRequest1Binding

class Request1Fragment:Fragment() {
    private lateinit var binding: FragmentRequest1Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRequest1Binding.inflate(layoutInflater)
        return binding.root
    }
}