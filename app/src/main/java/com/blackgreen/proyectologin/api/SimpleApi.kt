package com.blackgreen.proyectologin.api

import com.blackgreen.proyectologin.modelo.Post
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface SimpleApi {


    @POST("register")
    suspend fun pushPost(
        @Body post: Post
    ): Response<Post>

}
