package com.example.k_buddy.data.onBoard.repository

import com.example.k_buddy.data.BaseResponseDTO
import com.example.k_buddy.data.onBoard.dto.login.UserLoginReqDTO
import com.example.k_buddy.data.onBoard.dto.login.UserLoginResDTO
import com.example.k_buddy.data.onBoard.dto.testPing.PingResponseDTO
import retrofit2.Response

interface OnBoardingRepository {
    suspend fun userLogin(requestDTO: UserLoginReqDTO): Response<UserLoginResDTO>
    suspend fun testPing(): Response<PingResponseDTO>
}
