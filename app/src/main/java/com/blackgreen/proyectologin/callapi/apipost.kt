package com.blackgreen.proyectologin.callapi

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
        )

}