package com.blackgreen.proyectologin

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface RetroService {
    @POST("users")
    @Headers("Accept:application/json", "Content-Type:application/json",
        "Authorization: Bearer ba8292c4671c2adbf8e4afb5a5486e4047987c934763b18e9cee27f6042541cb")
    fun createUser(@Body params: User): Call<UserResponse>

}