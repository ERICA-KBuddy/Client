package com.example.k_buddy.ui.mainPage.ui.mypage.mysale.listings

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.k_buddy.databinding.ItemMysaleBinding
import com.example.k_buddy.ui.mainPage.ui.mypage.mysale.MysaleFragment
import com.example.k_buddy.ui.mainPage.ui.mypage.mysale.sales.SalesFragment
import com.example.k_buddy.ui.mainPage.ui.mypage.orders.OrdersAdapter
import com.example.k_buddy.ui.mainPage.ui.mypage.orders.OrdersFragment
import com.example.k_buddy.ui.mainPage.ui.mypage.orders.OrdersItem

class ListingsAdapter(private val items: List<ListingsItem>): RecyclerView.Adapter<ListingsAdapter.ListingsViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListingsViewHolder {
        val binding = ItemMysaleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListingsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListingsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ListingsViewHolder(private val binding: ItemMysaleBinding) :RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ListingsItem) {
            binding.itemImage.setImageResource(item.imageResId)
            binding.itemTitle.text = item.title
            binding.itemSellerId.text = item.sellerId
            binding.itemOrderDate.text = "Order date: ${item.orderDate}"
            binding.itemOrderSummary.text = "Order summary\n${item.orderSummary}"
            binding.itemPaidAmount.text = "Paid amount\n${item.paidAmount}"
        }
    }

}