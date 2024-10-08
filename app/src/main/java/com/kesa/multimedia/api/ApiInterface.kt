package com.kesa.multimedia.api

import com.google.ai.client.generativeai.common.shared.Part
import com.kesa.multimedia.model.LoginRequest
import com.kesa.multimedia.model.LoginResponse
import com.kesa.multimedia.model.PhotoResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST

interface ApiInterface {
    @Multipart
    @POST("/selfie")
    suspend fun uploadPhoto(
        @retrofit2.http.Part caption: MultipartBody.Part,
        @retrofit2.http.Part image: MultipartBody.Part
    ): Response<PhotoResponse>

    @POST("/auth/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

}