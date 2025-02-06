package com.example.terceiraapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.terceiraapp.databinding.ActivityPedirPrimeiroNumeroBinding

class PedirPrimeiroNumero : AppCompatActivity() {

    private val binding by lazy {
        ActivityPedirPrimeiroNumeroBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}