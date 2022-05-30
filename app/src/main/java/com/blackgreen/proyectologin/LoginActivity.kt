package com.blackgreen.proyectologin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


class LoginActivity : AppCompatActivity() {
    lateinit var btnpRegister:Button
    lateinit var etNameRegister:EditText
    lateinit var etEmailRegister:EditText
    lateinit var etPassRegister:EditText
    lateinit var etPassConfRegister:EditText

    lateinit var viewModel: MyViewModel
    //private val myAdapter by lazy { MyAdap }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnpRegister = findViewById(R.id.btnpRegister)
        etNameRegister = findViewById(R.id.etNameRegister)
        etEmailRegister = findViewById(R.id.etEmailRegister)
        etPassRegister = findViewById(R.id.etPassRegister)
        etPassConfRegister = findViewById(R.id.etPassConfRegister)

        initViewModel()
        btnpRegister.setOnClickListener {
            createUser()
        }

    }

    private fun createUser() {
        val user = User("",etNameRegister.text.toString(),etEmailRegister.text.toString(), "Active", "Male")
        viewModel.createNewUser(user)
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        viewModel.getCreateNewUserObserver().observe(this, Observer <UserResponse>{

            if (it == null){
                Toast.makeText(this@LoginActivity, "Failed to create User", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this@LoginActivity, "Successfully created User", Toast.LENGTH_LONG).show()
            }
        })
    }


}