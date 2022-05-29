package com.blackgreen.proyectologin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.EditText as EditText

class MainActivity : AppCompatActivity() {

    lateinit var tvRegistrar:TextView
    lateinit var btnIngresar :Button
    lateinit var etCorreo: EditText
    lateinit var etContrasena: EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvRegistrar = findViewById(R.id.tvRegistro)
        btnIngresar = findViewById(R.id.btnIniciarSecion)
        etCorreo    = findViewById(R.id.etCorreo)
        etContrasena = findViewById(R.id.etContrasena)

        tvRegistrar.setOnClickListener{
            var intentRegister = Intent(this,LoginActivity::class.java)
            startActivity(intentRegister)

        }

    }
}