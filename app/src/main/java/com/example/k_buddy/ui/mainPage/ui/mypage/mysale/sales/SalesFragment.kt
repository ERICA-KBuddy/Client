package com.example.k_buddy.ui.mainPage.ui.mypage.mysale.sales

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.k_buddy.databinding.FragmentSalesBinding
import com.example.k_buddy.ui.createItinerary.CreateItineraryActivity
import com.example.k_buddy.ui.mainPage.ui.market.ConnectionActivity

class SalesFragment : Fragment() {

    private val viewModel: SalesViewModel by viewModels()
    private var _binding: FragmentSalesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSalesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = SalesAdapter(viewModel.items) { item ->
            val intent = Intent(activity, CreateItineraryActivity::class.java)
            // 필요한 데이터를 인텐트에 추가
            startActivity(intent)
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}