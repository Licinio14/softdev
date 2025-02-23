package com.example.terceiraapp.views

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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

            if (num2 == ""){
                Toast.makeText(this,"O campo é de preenchimento OBRIGATORIO!", Toast.LENGTH_SHORT).show()
            }else{
                val a = Intent(this, MostrarContasPrimeiroSegundoNumero::class.java)
                a.putExtra("num1",num1)
                a.putExtra("num2",num2)
                startActivity(a)
            }
        }

    }
}