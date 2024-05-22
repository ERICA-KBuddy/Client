package com.example.k_buddy.ui.mainPage.ui.mypage.mysale

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.k_buddy.databinding.FragmentMysaleBinding

class MysaleFragment : Fragment() {

    private var _binding: FragmentMysaleBinding? = null
    private val binding get() = _binding!!

    // ViewModel을 by viewModels()를 사용하여 초기화
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

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = MysaleAdapter(viewModel.items)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}