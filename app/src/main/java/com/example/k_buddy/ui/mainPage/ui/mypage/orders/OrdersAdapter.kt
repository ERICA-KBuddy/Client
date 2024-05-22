package com.example.k_buddy.ui.mainPage.ui.mypage.orders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.k_buddy.databinding.ItemMysaleBinding

class OrdersAdapter(private val items: List<OrdersItem>) : RecyclerView.Adapter<OrdersAdapter.OrdersViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OrdersViewHolder {
        val binding = ItemMysaleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrdersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrdersViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class OrdersViewHolder(private val binding: ItemMysaleBinding) :RecyclerView.ViewHolder(binding.root) {
        fun bind(item: OrdersItem) {
            binding.itemImage.setImageResource(item.imageResId)
            binding.itemTitle.text = item.title
            binding.itemSellerId.text = item.sellerId
            binding.itemOrderDate.text = "Order date: ${item.orderDate}"
            binding.itemOrderSummary.text = "Order summary\n${item.orderSummary}"
            binding.itemPaidAmount.text = "Paid amount\n${item.paidAmount}"
        }
    }

}