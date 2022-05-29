package com.blackgreen.proyectologin.repositorio

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.blackgreen.proyectologin.callapi.apipost
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class repositoriouser {

    fun userRegister(
        name: String,
        email: String,
        password: String,
        password_Confirmation: String
    ): LiveData<String> {
        val registerResponse = MutableLiveData<String>()

        apipost().UserRegister(name, email, password, password_Confirmation)
            .enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    registerResponse.value = t.message
                }

                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if (response.isSuccessful) {
                        registerResponse.value = response.body()?.string()
                    } else {
                        registerResponse.value = response.errorBody()?.string()
                    }
                }

            })
        return registerResponse
    }
}