package com.example.terceiraapp.views

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.terceiraapp.databinding.ActivityPedirPrimeiroNumeroBinding

class PedirPrimeiroNumero : AppCompatActivity() {

    private val binding by lazy {
        ActivityPedirPrimeiroNumeroBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.bttPedirPrimeiroNumero.setOnClickListener {
            var num1 = binding.inputPedirPrimeiroNumero.text.toString()
            if (num1 == ""){
                Toast.makeText(this,"O campo é de preenchimento OBRIGATORIO!",Toast.LENGTH_SHORT).show()
            }else{
                val i = Intent(this, PedirSegundoNumero::class.java)
                i.putExtra("num1",num1)
                startActivity(i)
            }
        }



        binding.bttPedirPrimeiroNumeroHome.setOnClickListener {
            startActivity(Intent(this, Menu::class.java))
        }

    }
}