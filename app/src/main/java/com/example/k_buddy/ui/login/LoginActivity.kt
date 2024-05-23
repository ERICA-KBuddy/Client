package com.example.k_buddy.ui.login

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import com.example.k_buddy.R
import com.example.k_buddy.databinding.ActivityLoginBinding
import com.example.k_buddy.ui.mainPage.MainPageActivity

class LoginActivity : AppCompatActivity() {

    private val loginViewModel: LoginViewModel by viewModels()
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // CreateAccount 섹션 클릭 이벤트 처리
        binding.radioCreateAccount.setOnClickListener {
            loginViewModel.toggleCreateAccountVisibility()
        }

        // LogIn 섹션 클릭 이벤트 처리
        binding.radioLogIn.setOnClickListener {
            loginViewModel.toggleLogInVisibility()
        }

        // ViewModel의 LiveData 관찰
        loginViewModel.createAccountVisibility.observe(this, Observer { isVisible ->
            setCreateAccountVisibility(isVisible)
        })

        loginViewModel.logInVisibility.observe(this, Observer { isVisible ->
            setLogInVisibility(isVisible)
        })

        /*
            SignUp 버튼 클릭
         */
        binding.buttonSignUp.setOnClickListener {
            // Handle sign up logic
        }

        /*
            LogIn 버튼 클릭
         */
        binding.buttonLogIn.setOnClickListener {
            // Handle log in logic

//            val username = binding.editTextLoginUserId.text.toString()
//            val password = binding.editTextLoginPassword.text.toString()

            /*
                임시로 화면 전환
             */
            val intent = Intent(this, MainPageActivity::class.java)
            startActivity(intent)
            finish()

            //        loginViewModel.loginResult.observe(this, Observer { response ->
//            if (response.isSuccessful) {
//                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
//            } else {
//                Toast.makeText(this, "Login failed: ${response.message()}", Toast.LENGTH_SHORT).show()
//            }
//        })
//
//        loginViewModel.loginError.observe(this, Observer { error ->
//            Toast.makeText(this, "Error: $error", Toast.LENGTH_SHORT).show()
//        })
        }

        /*
            password 재입력 확인
         */
        binding.editTextPassword.addTextChangedListener {
            validatePasswordCriteria(it.toString())
            validatePasswordMatch()
        }

        /*
            password 조건 확인
         */
        binding.editTextConfirmPassword.addTextChangedListener {
            validatePasswordMatch()
        }

        /*
            userId 조건 확인
         */
        binding.editTextUserId.addTextChangedListener {
            validateUserIdUsable(it.toString())
        }
    }

    /*
        CreateAccount section visibility
     */
    private fun setCreateAccountVisibility(isCreateAccount: Boolean) {
        binding.createAccountSection.visibility = if (isCreateAccount) View.VISIBLE else View.GONE
        binding.radioCreateAccount.isChecked = if (isCreateAccount) true else false
    }

    /*
        Login section visibility
     */
    private fun setLogInVisibility(isLogin: Boolean) {
        binding.logInSection.visibility = if (isLogin) View.VISIBLE else View.GONE
        binding.radioLogIn.isChecked = if (isLogin) true else false
    }

    /*
        UserId 사용 가능한지 확인하는 함수
     */
    @SuppressLint("SetTextI18n")
    private fun validateUserIdUsable(userid: String) {
        val isValid = userid.isNotEmpty()
        if(isValid) binding.textUserIdStatus.text = "You can use this ID."
        else binding.textUserIdStatus.text = "You can not use this ID."
    }

    /*
        Password 조건 확인하는 함수
     */
    private fun validatePasswordCriteria(password: String) {
        val criteriaMet = password.length >= 8 &&
                password.any { it.isUpperCase() } &&
                password.any { it.isDigit() }
        binding.textPasswordCriteria.setTextColor(
            if (criteriaMet) resources.getColor(android.R.color.holo_green_dark)
            else resources.getColor(android.R.color.holo_red_dark)
        )
    }

    /*
        password 재입력 확인하는 함수
     */
    private fun validatePasswordMatch() {
        val password = binding.editTextPassword.text.toString()
        val confirmPassword = binding.editTextConfirmPassword.text.toString()
        val match = password == confirmPassword
        binding.textPasswordMatch.setTextColor(
            if (match) resources.getColor(android.R.color.holo_green_dark)
            else resources.getColor(android.R.color.holo_red_dark)
        )
    }
}
