package com.example.k_buddy.recyclerviewAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.k_buddy.R
import com.example.k_buddy.data.recyclerviewData.marketItem

class MarketAdapter(private var items : List<marketItem>,private val onItemClick: (marketItem) -> Unit): RecyclerView.Adapter<MarketAdapter.MarketViewHolder>() {
    inner class MarketViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.name1)
        val sellerIdTextView: TextView = itemView.findViewById(R.id.seller_id)
        val ratingTextView: TextView = itemView.findViewById(R.id.tttt)
        val hashtagsTextView: TextView = itemView.findViewById(R.id.hashtag)
        val dayTextView: TextView = itemView.findViewById(R.id.day)
        val priceTextView: TextView = itemView.findViewById(R.id.price)
        val imageView: ImageView = itemView.findViewById(R.id.image1)
        init {
            itemView.setOnClickListener {
                onItemClick(items[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_market, parent, false)
        return MarketViewHolder(view)
    }

    override fun onBindViewHolder(holder: MarketViewHolder, position: Int) {
        val item = items[position]
        holder.nameTextView.text = item.name
        holder.sellerIdTextView.text = item.sellerId
        holder.ratingTextView.text = item.rating
        holder.hashtagsTextView.text = item.hashtags
        holder.dayTextView.text = item.day
        holder.priceTextView.text = item.price
        holder.imageView.setImageResource(item.imageUrl)
    }

    override fun getItemCount(): Int = items.size


}