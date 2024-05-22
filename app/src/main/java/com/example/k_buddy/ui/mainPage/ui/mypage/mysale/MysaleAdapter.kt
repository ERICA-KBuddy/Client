package com.example.k_buddy.ui.mainPage.ui.mypage.mysale

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.k_buddy.databinding.ItemMysaleBinding

class MysaleAdapter(private val items: List<MysaleItem>) : RecyclerView.Adapter<MysaleAdapter.MySaleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MySaleViewHolder {
        val binding = ItemMysaleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MySaleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MySaleViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class MySaleViewHolder(private val binding: ItemMysaleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MysaleItem) {
            binding.itemImage.setImageResource(item.imageResId)
            binding.itemTitle.text = item.title
            binding.itemSellerId.text = item.sellerId
            binding.itemOrderDate.text = "Order date: ${item.orderDate}"
            binding.itemOrderSummary.text = "Order summary\n${item.orderSummary}"
            binding.itemPaidAmount.text = "Paid amount\n${item.paidAmount}"
        }
    }
}