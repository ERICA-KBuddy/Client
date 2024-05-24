package com.example.k_buddy.ui.mainPage.ui.mypage.mysale.listings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.k_buddy.R
import com.example.k_buddy.databinding.FragmentListingsBinding
import com.example.k_buddy.ui.mainPage.ui.mypage.orders.OrdersAdapter

class ListingsFragment : Fragment() {

    // ViewModel을 by viewModels()를 사용하여 초기화
    private val viewModel: ListingsViewModel by viewModels()
    private var _binding: FragmentListingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListingsBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = ListingsAdapter(viewModel.items)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}