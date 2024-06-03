package com.example.k_buddy.data.onBoard.repository

import com.example.k_buddy.data.BaseResponseDTO
import com.example.k_buddy.data.ServiceConnector
import com.example.k_buddy.data.onBoard.dto.login.UserLoginReqDTO
import com.example.k_buddy.data.onBoard.dto.login.UserLoginResDTO
import com.example.k_buddy.data.onBoard.dto.testPing.PingResponseDTO
import com.example.k_buddy.data.onBoard.service.OnBoardService
import retrofit2.Response

class OnBoardingRepositoryImpl() : OnBoardingRepository {
    private val onBoardService: OnBoardService = ServiceConnector.onBoardService


    override suspend fun userLogin(requestDTO: UserLoginReqDTO): Response<UserLoginResDTO> {
        return onBoardService.postUserLogin(requestDTO)
    }

    override suspend fun testPing(): Response<PingResponseDTO> {
        return onBoardService.healthCheck()
    }
}
