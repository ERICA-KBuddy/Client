package com.example.k_buddy.ui.mainPage.ui.mypage.mysale

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.k_buddy.R
import com.example.k_buddy.databinding.FragmentMysaleBinding

class MysaleFragment : Fragment() {

    private var _binding: FragmentMysaleBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MysaleViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMysaleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
        setupButtons()
    }

    private fun setupViewPager() {
        val viewPager = binding.mySaleViewPager
        val adapter = MysaleAdapter(requireActivity())
        viewPager.adapter = adapter
    }

    private fun setupButtons() {
        binding.buttonSales.setOnClickListener {
            binding.mySaleViewPager.currentItem = 0
            binding.buttonSales.setBackgroundResource(R.drawable.mysale_clicked_button)
            binding.buttonListings.setBackgroundResource(R.drawable.mysale_unclicked_button)
        }

        binding.buttonListings.setOnClickListener {
            binding.mySaleViewPager.currentItem = 1
            binding.buttonSales.setBackgroundResource(R.drawable.mysale_unclicked_button)
            binding.buttonListings.setBackgroundResource(R.drawable.mysale_clicked_button)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}