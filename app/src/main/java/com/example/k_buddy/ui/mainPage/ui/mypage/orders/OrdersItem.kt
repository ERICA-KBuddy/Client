package com.example.k_buddy.ui.mainPage.ui.mypage.orders

data class OrdersItem (
    val imageResId: Int,
    val title: String,
    val sellerId: String,
    val orderDate: String,
    val orderSummary: String,
    val paidAmount: String
)