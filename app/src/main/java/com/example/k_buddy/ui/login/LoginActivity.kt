package com.example.k_buddy.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.k_buddy.R
import com.example.k_buddy.databinding.ActivityLoginBinding
import com.example.k_buddy.ui.MainActivity

class LoginActivity : AppCompatActivity() {

    private val loginViewModel: LoginViewModel by viewModels()
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            val username = binding.username.text.toString()
            val password = binding.password.text.toString()
            /*
                로그인 시도
             */
//            loginViewModel.login(username, password)
            /*
                임시로 전환
             */
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

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
}
