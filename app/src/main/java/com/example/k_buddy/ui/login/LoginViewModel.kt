package com.example.k_buddy.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.k_buddy.data.onBoard.dto.login.UserLoginReqDTO
import com.example.k_buddy.data.onBoard.repository.OnBoardingRepository
import com.example.k_buddy.data.onBoard.repository.OnBoardingRepositoryImpl
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel : ViewModel() {

    private val onBoardingRepository: OnBoardingRepository = OnBoardingRepositoryImpl()

    val loginResult = MutableLiveData<Response<Any>>()
    val loginError = MutableLiveData<String>()

    fun login(username: String, password: String) {
        val requestDTO = UserLoginReqDTO(username, password)
        viewModelScope.launch {
            try {
                val response = onBoardingRepository.userLogin(requestDTO)
            } catch (e: Exception) {
                loginError.postValue(e.message)
            }
        }
    }
}
