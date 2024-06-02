package com.example.k_buddy.ui.createItinerary

data class Transport (
    var type: Int ,
    var totalduration: String = "",
    var durationUnit: Int,
    var description: String = ""
)