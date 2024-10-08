package com.kesa.multimedia.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.kesa.multimedia.R
import com.kesa.multimedia.databinding.ActivityLoginBinding
import com.kesa.multimedia.model.LoginRequest
import com.kesa.multimedia.model.LoginResponse
import com.kesa.multimedia.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding
    val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btnLogin.setOnClickListener{ validateLogin() }

        loginViewModel.errorLiveData.observe(this){ error ->
            Toast.makeText(this, error , Toast.LENGTH_LONG).show()
        }

        loginViewModel.loginLiveData.observe(this){ LoginResponse ->
            Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show()
            startActivity(Intent(this, Home::class.java))
        }
    }


    private fun validateLogin(){
        val username = binding.tilUsername.text.toString()
        val password = binding.tilPassword.text.toString()
        var error = false

        if (username.isBlank()){
            binding.etUsername.error = "Username Required"
            error = true

        }

        if (password.isBlank()){
            binding.etPassword.error = "Password Required"
            error = true

        }

        if (!error){
            val loginRequest = LoginRequest(username, password)
            loginViewModel.login(loginRequest)
        }
}
}