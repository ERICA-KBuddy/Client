package com.example.k_buddy.ui.mainPage.ui.mypage.orders

import androidx.lifecycle.ViewModel
import com.example.k_buddy.R

class OrdersViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    val items = listOf(
        OrdersItem(R.drawable.sample_place_9, "Heading of the item", "@Seller's ID", "Order date", "3 days 2 nights", "30,000 won"),
        OrdersItem(R.drawable.sample_place_2, "Heading of the item", "@Seller's ID", "Order date", "3 days 2 nights", "30,000 won"),
        OrdersItem(R.drawable.sample_place_4, "Heading of the item", "@Seller's ID", "Order date", "3 days 2 nights", "30,000 won"),
    )
}