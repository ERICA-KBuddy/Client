package com.example.k_buddy.data.onBoard.repository

import com.example.k_buddy.data.onBoard.dto.login.UserLoginReqDTO
import com.example.k_buddy.data.onBoard.dto.login.UserLoginResDTO
import retrofit2.Response

interface OnBoardingRepository {
    suspend fun userLogin(requestDTO: UserLoginReqDTO): Response<UserLoginResDTO>
}
