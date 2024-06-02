package com.example.k_buddy.ui.mainPage.ui.mypage.mysale.sales

import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.k_buddy.databinding.ItemMysaleBinding

class SalesAdapter(
    private val items: List<SalesItem>,
    private val itemClickListener: (SalesItem) -> Unit
): RecyclerView.Adapter<SalesAdapter.SalesViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SalesViewHolder {
        val binding = ItemMysaleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SalesViewHolder(binding, itemClickListener)
    }

    override fun onBindViewHolder(holder: SalesViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class SalesViewHolder(
        private val binding: ItemMysaleBinding,
        private val itemClickListener: (SalesItem) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SalesItem) {
            binding.itemImage.setImageResource(item.imageResId)
            binding.itemTitle.text = item.title
            binding.itemSellerId.text = item.sellerId
            binding.itemOrderDate.text = "Order date: ${item.orderDate}"
            binding.itemOrderSummary.text = "Order summary\n${item.orderSummary}"
            binding.itemPaidAmount.text = "Paid amount\n${item.paidAmount}"
            itemView.setOnClickListener {
                itemClickListener(item)
            }
        }
    }
}
