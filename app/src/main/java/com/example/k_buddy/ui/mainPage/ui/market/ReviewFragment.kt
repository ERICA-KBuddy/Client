package com.example.k_buddy.ui.mainPage.ui.market

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.k_buddy.databinding.FragmentPhotoBinding
import com.example.k_buddy.databinding.FragmentReviewBinding

class ReviewFragment:Fragment() {
    private lateinit var binding: FragmentReviewBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReviewBinding.inflate(layoutInflater)
        return binding.root
    }
}