package com.example.terceiraapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.terceiraapp.databinding.ActivityMostrarInformacoesUserBinding

class MostrarInformacoesUser : AppCompatActivity() {

    private val binding by lazy {
        ActivityMostrarInformacoesUserBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val i = intent

        var nome = i.extras?.getString("nome")
        var rua = i.extras?.getString("rua")
        var telefone = i.extras?.getString("telefone")
        var email = i.extras?.getString("email")
        var genero = i.extras?.getString("genero")

        if (genero == "M"){
            binding.mostrarInformacaoUser.text = "O $nome mora na rua $rua, tem o telefone $telefone e o email é $email"
        }else if (genero == "F"){
            binding.mostrarInformacaoUser.text = "A $nome mora na rua $rua, tem o telefone $telefone e o email é $email"
        }else {
            binding.mostrarInformacaoUser.text = "O/A $nome mora na rua $rua, tem o telefone $telefone e o email é $email"
        }

        binding.bttMostrarInformacaoVoltar.setOnClickListener {
            startActivity(Intent(this,PedirInformacoesUser::class.java))
        }

    }
}