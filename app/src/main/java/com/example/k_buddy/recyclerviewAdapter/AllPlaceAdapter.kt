package com.example.k_buddy.recyclerviewAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.k_buddy.R
import com.example.k_buddy.data.recyclerviewData.allPlaceItem

class AllPlaceAdapter(private var items :List<allPlaceItem>) : RecyclerView.Adapter<AllPlaceAdapter.AllPlaceViewHolder>() {
    inner class AllPlaceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.name1)
        val imageView: ImageView = itemView.findViewById(R.id.image1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllPlaceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_all_place, parent, false)
        return AllPlaceViewHolder(view)
    }

    override fun onBindViewHolder(holder: AllPlaceViewHolder, position: Int) {
        val item = items[position]
        holder.nameTextView.text = item.name
        holder.imageView.setImageResource(item.imageUrl)
    }

    override fun getItemCount(): Int = items.size



}