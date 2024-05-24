package com.example.k_buddy.ui.login

import androidx.lifecycle.LiveData
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

    private val _createAccountVisibility = MutableLiveData(false)
    val createAccountVisibility: LiveData<Boolean> get() = _createAccountVisibility

    private val _logInVisibility = MutableLiveData(false)
    val logInVisibility: LiveData<Boolean> get() = _logInVisibility

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
    fun toggleCreateAccountVisibility() {
        if (_createAccountVisibility.value == true) {
            _createAccountVisibility.value = false
        } else {
            _createAccountVisibility.value = true
            _logInVisibility.value = false
        }
    }

    fun toggleLogInVisibility() {
        if (_logInVisibility.value == true) {
            _logInVisibility.value = false
        } else {
            _logInVisibility.value = true
            _createAccountVisibility.value = false
        }
    }
}
