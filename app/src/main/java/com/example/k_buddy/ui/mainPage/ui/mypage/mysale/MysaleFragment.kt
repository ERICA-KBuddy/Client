package com.example.k_buddy.ui.mainPage.ui.mypage.mysale

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.k_buddy.databinding.FragmentMysaleBinding
import com.google.android.material.tabs.TabLayoutMediator

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
        setupViewPagerAndTabs()
    }
    private fun setupViewPagerAndTabs() {
        // ViewPager 설정
        val viewPager = binding.mySaleViewPager
        val tabLayout = binding.mySaleTabLayout
        val adapter = MysaleAdapter(requireActivity())
        viewPager.adapter = adapter

        // TabLayout과 ViewPager 연결
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Sales"
                1 -> "Listings"
                else -> null
            }
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}