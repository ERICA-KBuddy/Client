package com.example.k_buddy.data.onBoard.dto.login

import com.example.k_buddy.data.BaseResponseDTO
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @param role only can be "ROLE_USER" or "ROLE_ADMIN"
 */
@Serializable
data class UserLoginResDTO(
    override val msg: String,
    @SerialName("token")
    val token: String
) : BaseResponseDTO
