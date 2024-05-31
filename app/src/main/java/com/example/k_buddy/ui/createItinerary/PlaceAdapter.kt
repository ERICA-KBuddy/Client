package com.example.k_buddy.ui.createItinerary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.k_buddy.databinding.ItemPlaceBinding

class PlaceAdapter : RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder>() {

    private val placeList = mutableListOf<Place>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val binding = ItemPlaceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlaceViewHolder(binding)

    }inner class PlaceViewHolder(private val binding: ItemPlaceBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(place: Place) {
            binding.editTextPlaceName.setText(place.name)
            binding.editTextPlaceAddress.setText(place.address)
            binding.editTextPlaceDescription.setText(place.description)
        }
    }


    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        holder.bind(placeList[position])
    }

    override fun getItemCount(): Int = placeList.size

    fun updateItems(newPlaces: List<Place>) {
        placeList.clear()
        placeList.addAll(newPlaces)
        notifyDataSetChanged()
    }
    fun addPlace(place: Place) {
        placeList.add(place)
        notifyItemInserted(placeList.size - 1)
    }
}
