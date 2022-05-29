package com.blackgreen.proyectologin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var tvRegistrar:TextView
    lateinit var btnIngresar :Button
    lateinit var etCorreo:EditText
    lateinit var etContraseña:EditText

    String url = "http://t8dos.herokuapp.com/api/register/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvRegistrar = findViewById(R.id.tvRegistro)
        btnIngresar = findViewById(R.id.btnIniciarSecion)
        etCorreo    = findViewById(R.id.etCorreo)
        etContraseña = findViewById(R.id.etContraseña)




    }
}