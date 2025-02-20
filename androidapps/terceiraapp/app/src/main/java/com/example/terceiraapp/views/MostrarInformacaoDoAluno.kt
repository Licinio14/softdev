package com.example.terceiraapp.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.terceiraapp.databinding.ActivityMostrarInformacaoDoAlunoBinding

class MostrarInformacaoDoAluno : AppCompatActivity() {

    public val binding by lazy {
        ActivityMostrarInformacaoDoAlunoBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val i = intent
        var name = i.extras?.getString("aluno")
        var morada = i.extras?.getString("morada")
        var email = i.extras?.getString("email")

        binding.showName.text = name.toString()
        binding.showMorada.text = morada.toString()
        binding.showEmail.text = email.toString()

        binding.bttExMostrarInformacaoAlunoVoltar.setOnClickListener {
            startActivity(Intent(this, ExMostrarListaAlunos::class.java))
        }


    }
}