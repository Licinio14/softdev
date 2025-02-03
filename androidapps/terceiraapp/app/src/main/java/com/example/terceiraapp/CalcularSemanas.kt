package com.example.terceiraapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.terceiraapp.databinding.ActivityCalcularSemanasBinding

class CalcularSemanas : AppCompatActivity() {

    private val binding by lazy {
        ActivityCalcularSemanasBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.bttCalcularHorasParaSemanas.setOnClickListener {
            var inputHoras: Int = binding.inputHorasParaSemanas.text.toString().toInt()

            var semanas: Int = inputHoras / (24*7)
            inputHoras = inputHoras - (semanas*7*24)
            var dias: Int = inputHoras / 24
            inputHoras = inputHoras - (dias * 24)
            var horas: Int = inputHoras;

            binding.resultadoHorasParaSemanas.text = semanas.toString()
            binding.resultadoHorasParaDias.text = dias.toString()
            binding.resultadoHorasParaHoras.text = horas.toString()

        }

        binding.bttHorasParaSemanasHome.setOnClickListener {
            startActivity(Intent(this,Menu::class.java))
        }

    }
}