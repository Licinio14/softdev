package com.example.segundaapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.segundaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.buttonPeso.setOnClickListener{
            if (binding.editValorEuros.text.toString().isEmpty()){
                Toast.makeText(this, "Insira algum valor!!!", Toast.LENGTH_SHORT).show()
            }else {
                var euros: Double = binding.editValorEuros.text.toString().toDouble()
                var newValue = euros * 31.5
                Toast.makeText(this, "Valor em Pesos: $newValue", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonReal.setOnClickListener{
            if (binding.editValorEuros.text.toString().isEmpty()){
                Toast.makeText(this, "Insira algum valor!!!", Toast.LENGTH_SHORT).show()
            }else {
                var euros: Double = binding.editValorEuros.text.toString().toDouble()
                var newValue = euros * 4.4
                Toast.makeText(this, "Valor em Real: $newValue", Toast.LENGTH_SHORT).show()
            }

        }

        binding.buttonDolar.setOnClickListener{
            if (binding.editValorEuros.text.toString().isEmpty()){
                Toast.makeText(this, "Insira algum valor!!!", Toast.LENGTH_SHORT).show()
            }else {
                var euros: Double = binding.editValorEuros.text.toString().toDouble()
                var newValue = euros * 1.2
                Toast.makeText(this, "Valor em Dolar: $newValue", Toast.LENGTH_SHORT).show()
            }

        }

    }
}