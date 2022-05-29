package com.blackgreen.proyectologin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.blackgreen.proyectologin.modelo.Post
import com.blackgreen.proyectologin.repositorio.Repository

class LoginActivity : AppCompatActivity() {
    lateinit var btnpRegister:Button
    lateinit var etNameRegister:EditText
    lateinit var etEmailRegister:EditText
    lateinit var etPassRegister:EditText
    lateinit var etPassConfRegister:EditText

    private lateinit var viewModel: myViewModel
    //private val myAdapter by lazy { MyAdap }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnpRegister = findViewById(R.id.btnpRegister)
        etNameRegister = findViewById(R.id.etNameRegister)
        etEmailRegister = findViewById(R.id.etEmailRegister)
        etPassRegister = findViewById(R.id.etPassRegister)
        etPassConfRegister = findViewById(R.id.etPassConfRegister)


        val repository = Repository()
        val viewModelFactory = myViewModel(repository)
        //viewModel = ViewModelProvider(this,viewModelFactory).get(myViewModel::class.java)
        val myPost = Post(etNameRegister.text.toString(),
                      etEmailRegister.text.toString(),
                      etPassRegister.text.toString(),
                      etPassConfRegister.text.toString())//Post("Erick","algo@algoc.com","hola","hola")
        viewModel.pushPost(myPost)
        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful){
                Log.d("Main",response.body().toString())
                Log.d("Main",response.code().toString())
                Log.d("Main",response.message())
            }else{
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })



    }


}