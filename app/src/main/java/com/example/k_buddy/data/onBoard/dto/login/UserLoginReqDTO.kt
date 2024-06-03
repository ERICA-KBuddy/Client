package com.example.k_buddy.data.onBoard.dto.login

import com.google.gson.annotations.SerializedName

data class UserLoginReqDTO(
    @SerializedName("identifier")
    val identifier: String,
    @SerializedName("password")
    val password: String,
)