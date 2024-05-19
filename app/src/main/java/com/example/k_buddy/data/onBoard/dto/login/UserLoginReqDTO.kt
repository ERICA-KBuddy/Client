package com.example.k_buddy.data.onBoard.dto.login

import com.google.gson.annotations.SerializedName

data class UserLoginReqDTO(
    @SerializedName("user_id")
    val userId: String,
    @SerializedName("password")
    val password: String,
)