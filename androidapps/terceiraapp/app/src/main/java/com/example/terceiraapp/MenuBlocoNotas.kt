package com.example.terceiraapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.terceiraapp.databinding.ActivityMenuBlocoNotasBinding

class MenuBlocoNotas : AppCompatActivity() {

    public val binding by lazy {
        ActivityMenuBlocoNotasBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.bttInserirNotas.setOnClickListener {
            startActivity(Intent(this,InserirNotas::class.java))
        }

        binding.bttMenuNotasHome.setOnClickListener {
            startActivity(Intent(this,Menu::class.java))
        }

        binding.bttVerNotas.setOnClickListener {
            startActivity(Intent(this,VerNotas::class.java))
        }
    }
}