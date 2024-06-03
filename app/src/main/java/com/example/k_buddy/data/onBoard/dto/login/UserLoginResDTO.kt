package com.example.k_buddy.data.onBoard.dto.login

import com.example.k_buddy.data.BaseResponseDTO

data class UserLoginResDTO(
    override val message: String,
    val token: String
) : BaseResponseDTO
