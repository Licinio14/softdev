package com.example.terceiraapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.terceiraapp.databinding.ActivityExMudarNomeHomeBinding

class exMudarNomeHome : AppCompatActivity() {

    private val binding by lazy {
        ActivityExMudarNomeHomeBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val i = intent

        val nome = i.extras?.getString("user_name")

        if (nome == null){
            binding.labelOlaUsuario.text = "Olá usuario"
        }else if (nome == ""){
            binding.labelOlaUsuario.text = "Olá usuario"
        }else{
            binding.labelOlaUsuario.text = "Olá $nome"
        }


        binding.bttMudarONomeNaLabel.setOnClickListener {
            val intent = Intent(this,ExMudarNomeForm::class.java)
            startActivity(intent)
        }

        binding.bttMudarONomeNaLabelHome.setOnClickListener {
            val intent = Intent(this,Menu::class.java)
            startActivity(intent)
        }

    }
}