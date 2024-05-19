package com.example.k_buddy.data.onBoard.dto.register

import com.example.k_buddy.data.BaseResponseDTO
import kotlinx.serialization.Serializable

@Serializable
data class UserRegisterResDTO(
    override val msg : String
) : BaseResponseDTO
