package com.example.k_buddy.data.onBoard.service

import com.example.k_buddy.data.onBoard.dto.login.UserLoginReqDTO
import com.example.k_buddy.data.onBoard.dto.login.UserLoginResDTO
import com.example.k_buddy.data.onBoard.dto.register.UserRegisterReqDTO
import com.example.k_buddy.data.onBoard.dto.register.UserRegisterResDTO
import retrofit2.http.Body
import retrofit2.http.POST

interface OnBoardService {
    /**
     *  자체 로그인
     */
    @POST("user/login")
    suspend fun postUserLogin(
        @Body requestBody : UserLoginReqDTO
    ) : UserLoginResDTO

    /**
     * 자체 회원가입
     */
    @POST("user/register")
    suspend fun postUserRegister(
        @Body requsetBody : UserRegisterReqDTO
    ) : UserRegisterResDTO

}