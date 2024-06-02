package com.example.k_buddy.ui.createItinerary

import ItineraryItem
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.k_buddy.R
import com.example.k_buddy.databinding.ItemPlaceBinding
import com.example.k_buddy.databinding.ItemTransportationBinding

class ItineraryAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = mutableListOf<ItineraryItem>()

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is ItineraryItem.PlaceItem -> R.layout.item_place
            is ItineraryItem.TransportItem -> R.layout.item_transportation
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.item_place -> PlaceViewHolder(ItemPlaceBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            R.layout.item_transportation -> TransportViewHolder(ItemTransportationBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is ItineraryItem.PlaceItem -> (holder as PlaceViewHolder).bind(item.place)
            is ItineraryItem.TransportItem -> (holder as TransportViewHolder).bind(item.transport)
            else -> throw IllegalArgumentException("Invalid view type")
        }

    }

    override fun getItemCount(): Int = items.size

    fun updateItems(newItems: List<ItineraryItem>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    inner class PlaceViewHolder(private val binding: ItemPlaceBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(place: Place) {
            binding.editTextPlaceName.setText(place.name)
            binding.editTextPlaceAddress.setText(place.address)
            binding.editTextPlaceDescription.setText(place.description)

            binding.editTextPlaceName.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    place.name = s.toString()
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            })

            binding.editTextPlaceAddress.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    place.address = s.toString()
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            })

            binding.editTextPlaceDescription.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    place.description = s.toString()
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            })
        }
    }

    inner class TransportViewHolder(private val binding: ItemTransportationBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(transport: Transport) {
            // Setting up Spinner adapters
            val transportTypeAdapter = ArrayAdapter.createFromResource(
                binding.root.context,
                R.array.transport_types,
                android.R.layout.simple_spinner_item
            )
            transportTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerTransportType.adapter = transportTypeAdapter

            val durationUnitsAdapter = ArrayAdapter.createFromResource(
                binding.root.context,
                R.array.duration_units,
                android.R.layout.simple_spinner_item
            )
            durationUnitsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerDurationUnits.adapter = durationUnitsAdapter

            // Setting Spinner selections and listeners
            binding.spinnerTransportType.setSelection(transport.type)
            binding.spinnerTransportType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                    if (parent.tag == null) {
                        parent.tag = true
                    } else {
                        transport.type = position
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>) {}
            }

            binding.spinnerDurationUnits.setSelection(transport.durationUnit)
            binding.spinnerDurationUnits.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                    if (parent.tag == null) {
                        parent.tag = true
                    } else {
                        transport.durationUnit = position
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>) {}
            }

            // Setting EditText listeners
            binding.editTextTotalDuration.setText(transport.totalduration)
            binding.editTextTotalDuration.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    transport.totalduration = s.toString()
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            })

            binding.editTextTransportationDescription.setText(transport.description)
            binding.editTextTransportationDescription.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    transport.description = s.toString()
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            })
        }
    }
}

