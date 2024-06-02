package com.example.k_buddy.ui.mainPage.ui.mypage

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.k_buddy.databinding.FragmentMypageBinding
import com.example.k_buddy.ui.mainPage.MainPageActivity
import com.example.k_buddy.ui.myPage.MyPageAdapter
import com.example.k_buddy.ui.profileEdit.EditListingsActivity
import com.google.android.material.tabs.TabLayoutMediator

class MypageFragment : Fragment() {

    private var _binding: FragmentMypageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val myPageViewModel = ViewModelProvider(this).get(MypageViewModel::class.java)
        _binding = FragmentMypageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPagerAndTabs()
        /*
            logo 클릭 시
         */
        binding.logoIcon.setOnClickListener {
            val intent = Intent(requireActivity(), MainPageActivity::class.java)
            startActivity(intent)
        }
        /*
            edit_profile_button 클릭 시 동작
         */
        binding.editProfileButton.setOnClickListener {
            val intent = Intent(requireActivity(), EditListingsActivity::class.java)
            startActivity(intent)
        }
        /*
            notification_button 클릭 시
         */
        binding.notificationIcon.setOnClickListener {

        }
        /*
            logoutIcon 클릭 시
         */
        binding.logoutIcon.setOnClickListener {

        }
    }

    private fun setupViewPagerAndTabs() {
        val viewPager = binding.myPageViewPager
        val tabLayout = binding.myPageTabLayout
        val adapter = MyPageAdapter(requireActivity())
        viewPager.adapter = adapter

        // Connect TabLayout with ViewPager2
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "My Sales"
                1 -> "Orders"
                else -> null
            }
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
