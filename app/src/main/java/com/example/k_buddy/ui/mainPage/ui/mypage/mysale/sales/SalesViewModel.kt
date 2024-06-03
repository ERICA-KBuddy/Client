package com.example.k_buddy.ui.mainPage.ui.mypage.mysale.sales

import androidx.lifecycle.ViewModel
import com.example.k_buddy.R
import com.example.k_buddy.ui.mainPage.ui.mypage.mysale.MysaleItem

class SalesViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    val items = listOf(
        SalesItem(R.drawable.sample_place_1, "Heading of the item", "@Seller's ID", "Order date", "3 days 2 nights", "30,000 won"),
        SalesItem(R.drawable.sample_place_2, "Heading of the item", "@Seller's ID", "Order date", "3 days 2 nights", "30,000 won"),
        SalesItem(R.drawable.sample_place_3, "Heading of the item", "@Seller's ID", "Order date", "3 days 2 nights", "30,000 won"),
        // 더 많은 아이템 추가
    )
}