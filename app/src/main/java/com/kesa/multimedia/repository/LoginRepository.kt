package com.kesa.multimedia.repository

import com.kesa.multimedia.api.ApiClient
import com.kesa.multimedia.api.ApiInterface
import com.kesa.multimedia.model.LoginRequest
import com.kesa.multimedia.model.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class LoginRepository {

    val apiClient = ApiClient.buildClient(ApiInterface::class.java)

    suspend fun login(loginRequest: LoginRequest):Response<LoginResponse>{
        return withContext(Dispatchers.IO){
            apiClient.login(loginRequest)
        }
    }
}