package com.blackgreen.proyectologin.callapi

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface apipost {

    @FormUrlEncoded
    @POST("register")
    fun UserRegister(
        @Field("name") etNomre: String,
        @Field("email") etEmail: String,
        @Field("password") etPassword: String,
        @Field("password_Confirmation") etPasswordConfirmation: String
        ): Call<ResponseBody>

    companion object{
        operator fun invoke() : apipost{
           return Retrofit.Builder()
               .baseUrl("http://t8dos.herkouapp.com/api/register")
               .addConverterFactory(GsonConverterFactory.create())
               .build()
               .create(apipost::class.java)
        }

    }
}
