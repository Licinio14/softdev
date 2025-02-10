package com.example.terceiraapp

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.terceiraapp.databinding.ActivityVerNotasBinding

class VerNotas : AppCompatActivity() {

    public val binding by lazy {
        ActivityVerNotasBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val sharedPreferences = this.getSharedPreferences("nota", Context.MODE_PRIVATE)
        val user = sharedPreferences.getString("nota","").toString()

        //binding.listViewMostrarNotas.adapter = user
    }
}