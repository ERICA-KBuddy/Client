package com.example.k_buddy.data.onBoard.dto.register

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserRegisterReqDTO(
    @SerialName("user_id")
    val userId : String,
    @SerialName("password")
    val password : String,
    @SerialName("name")
    val name : String,
    @SerialName("role")
    val role : String,
)