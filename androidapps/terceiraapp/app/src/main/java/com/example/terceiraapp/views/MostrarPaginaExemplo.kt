package com.example.terceiraapp.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.terceiraapp.databinding.ActivityMostrarPaginaExemploBinding

class MostrarPaginaExemplo : AppCompatActivity() {

    public val binding by lazy {
        ActivityMostrarPaginaExemploBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.bttPaginaExemploHome.setOnClickListener {
            startActivity(Intent(this, Menu::class.java))
        }

    }
}