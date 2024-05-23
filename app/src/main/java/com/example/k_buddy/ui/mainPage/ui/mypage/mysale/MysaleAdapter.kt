package com.example.k_buddy.ui.mainPage.ui.mypage.mysale

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.k_buddy.databinding.ItemMysaleBinding
import com.example.k_buddy.ui.mainPage.ui.mypage.mysale.listings.ListingsFragment
import com.example.k_buddy.ui.mainPage.ui.mypage.mysale.sales.SalesFragment
import com.example.k_buddy.ui.mainPage.ui.mypage.orders.OrdersFragment

class MysaleAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2 // 탭의 개수
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> SalesFragment()
            1 -> ListingsFragment()
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }
}