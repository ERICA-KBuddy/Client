package com.example.k_buddy.data.onBoard.repository

import com.example.k_buddy.data.onBoard.dto.login.UserLoginResDTO
import com.example.k_buddy.data.onBoard.dto.register.UserRegisterResDTO

interface OnBoardingRepository {
    suspend fun userLogin(
        mobileNo: String,
        password: String
    ): UserLoginResDTO

    suspend fun userRegister(
        mobileNo: String,
        password: String,
        name: String,
        role: String
    ): UserRegisterResDTO
}

