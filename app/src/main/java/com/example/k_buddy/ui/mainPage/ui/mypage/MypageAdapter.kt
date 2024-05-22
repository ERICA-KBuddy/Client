package com.example.k_buddy.ui.myPage

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.k_buddy.ui.mainPage.ui.mypage.MysaleFragment
import com.example.k_buddy.ui.mainPage.ui.mypage.OrdersFragment

class MyPageAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 2 // 탭의 개수
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MysaleFragment()
            1 -> OrdersFragment()
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }
}
