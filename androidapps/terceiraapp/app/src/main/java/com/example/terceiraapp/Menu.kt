package com.example.terceiraapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.terceiraapp.databinding.ActivityMenuBinding

class Menu : AppCompatActivity() {

    private val binding by lazy {
        ActivityMenuBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.bttChamarParPrimos.setOnClickListener {
            startActivity(Intent(this,LoginokActivity::class.java))
        }

        binding.bttCalcularSemanasHorasDias.setOnClickListener {
            startActivity(Intent(this,CalcularSemanas::class.java))
        }

        binding.bttExPassarVariaveis.setOnClickListener {
            startActivity(Intent(this,exMudarNomeHome::class.java))
        }

        binding.bttExPedirInformacao.setOnClickListener {
            startActivity(Intent(this,PedirInformacoesUser::class.java))
        }

        binding.bttExFazerOperacoesAleatorias.setOnClickListener {
            startActivity(Intent(this,PedirPrimeiroNumero::class.java))
        }
    }
}