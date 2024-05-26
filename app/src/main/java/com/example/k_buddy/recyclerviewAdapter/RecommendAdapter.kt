package com.example.k_buddy.recyclerviewAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.k_buddy.R


import com.example.k_buddy.data.recyclerviewData.recommendItem

class RecommendAdapter(private val items: List<recommendItem>) : RecyclerView.Adapter<RecommendAdapter.RecommendViewHolder>(){

    inner class RecommendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.name1)
        val categoryTextView: TextView = itemView.findViewById(R.id.asdsad)
        val ratingTextView: TextView = itemView.findViewById(R.id.tttt)
        val reviewTextView: TextView = itemView.findViewById(R.id.review)
        val imageView: ImageView = itemView.findViewById(R.id.image1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recommend, parent, false)
        return RecommendViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecommendViewHolder, position: Int) {
        val item = items[position]
        holder.nameTextView.text = item.name
        holder.categoryTextView.text = item.category
        holder.ratingTextView.text = item.rating
        holder.reviewTextView.text = item.reviewCount
        // 이미지 로딩 라이브러리 사용 (예: Glide)
        Glide.with(holder.itemView.context).load(item.imageUrl).into(holder.imageView)
    }

    override fun getItemCount(): Int = items.size

    }