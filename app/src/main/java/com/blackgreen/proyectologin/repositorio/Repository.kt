package com.blackgreen.proyectologin.repositorio

import com.blackgreen.proyectologin.api.RetrofitInstance
import com.blackgreen.proyectologin.modelo.Post
import retrofit2.Response

class Repository {

        suspend fun pushPost(post: Post): Response<Post> {
        return RetrofitInstance.api.pushPost(post)
        }

}