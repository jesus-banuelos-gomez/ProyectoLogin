package com.blackgreen.proyectologin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blackgreen.proyectologin.modelo.Post
import com.blackgreen.proyectologin.repositorio.Repository
import kotlinx.coroutines.launch
import retrofit2.Response


class myViewModel(private val repository: Repository): ViewModel() {

    var myResponse : MutableLiveData<Response<Post>> = MutableLiveData()


    fun pushPost(post: Post){
        viewModelScope.launch{
            val response = repository.pushPost(post)
            myResponse.value = response

        }
    }
}