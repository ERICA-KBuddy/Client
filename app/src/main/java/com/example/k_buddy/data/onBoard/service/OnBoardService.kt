package com.example.k_buddy.data.onBoard.service

import com.example.k_buddy.data.onBoard.dto.login.UserLoginReqDTO
import com.example.k_buddy.data.onBoard.dto.login.UserLoginResDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface OnBoardService {
    /**
     *  로그인
     */
    @POST("user/login")
    suspend fun postUserLogin(
        @Body requestBody: UserLoginReqDTO
    ): Response<UserLoginResDTO>
}
