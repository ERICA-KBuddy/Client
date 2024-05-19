package com.example.k_buddy.data.onBoard.repository

import com.example.k_buddy.data.onBoard.dto.login.UserLoginReqDTO
import com.example.k_buddy.data.onBoard.dto.login.UserLoginResDTO
import com.example.k_buddy.data.onBoard.dto.register.UserRegisterReqDTO
import com.example.k_buddy.data.onBoard.dto.register.UserRegisterResDTO
import com.example.k_buddy.data.onBoard.service.OnBoardService

class OnBoardingRepositoryImpl(
    private val onBoardService: OnBoardService
) : OnBoardingRepository {
    override suspend fun userLogin(userId: String, password: String): UserLoginResDTO =
        onBoardService.postUserLogin(
            UserLoginReqDTO(
                userId = userId,
                password = password
            )
        )

    override suspend fun userRegister(
        mobileNo: String,
        password: String,
        name: String,
        role: String
    ): UserRegisterResDTO = onBoardService.postUserRegister(
        UserRegisterReqDTO(
            userId = mobileNo,
            password = password,
            name = name,
            role = role,
        )
    )
}
