package com.example.k_buddy.ui.mainPage.ui.mypage.mysale

data class MysaleItem(
    val imageResId: Int,
    val title: String,
    val sellerId: String,
    val orderDate: String,
    val orderSummary: String,
    val paidAmount: String
)