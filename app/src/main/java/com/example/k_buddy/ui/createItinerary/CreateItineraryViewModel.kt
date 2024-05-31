package com.example.k_buddy.ui.createItinerary

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.k_buddy.ui.util.ToastHelper

class CreateItineraryViewModel : ViewModel() {

    private val _result_add_item_button = MutableLiveData<String>()
    val selectedItem: LiveData<String> get() = _result_add_item_button

    fun selectAddItem(item: String) {
        _result_add_item_button.value = item
        Log.e("hyunsu_Tst",item.toString())
        addPlace(Place("", "", ""))
    }

    private val _places = MutableLiveData<MutableList<Place>>(mutableListOf())
    val places: LiveData<MutableList<Place>> get() = _places

    fun addPlace(place: Place) {
        val updatedPlaces = _places.value ?: mutableListOf()
        updatedPlaces.add(place)
        _places.value = updatedPlaces
    }

    fun updatePlace(position: Int, place: Place) {
        _places.value?.let {
            it[position] = place
            _places.value = it
        }
    }

}
