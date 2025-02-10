package com.example.terceiraapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.terceiraapp.databinding.ActivityPedirSegundoNumeroBinding

class PedirSegundoNumero : AppCompatActivity() {

    public val binding by lazy {
        ActivityPedirSegundoNumeroBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val i = intent
        var num1 = i.extras?.getString("num1")

        binding.bttPassarSegundoNumero.setOnClickListener {
            var num2 = binding.inputSegundoNumero.text.toString()
            val a = Intent(this,MostrarContasPrimeiroSegundoNumero::class.java)
            a.putExtra("num1",num1)
            a.putExtra("num2",num2)
            startActivity(a)
        }

    }
}