package com.example.terceiraapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.terceiraapp.databinding.ActivityExMudarNomeFormBinding

class ExMudarNomeForm : AppCompatActivity() {

    private val binding by lazy {
        ActivityExMudarNomeFormBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)




        binding.bttMudarNomeEx06.setOnClickListener {
            var nome: String = binding.editNameEx06.text.toString()

            val i = Intent(this,exMudarNomeHome::class.java)
            i.putExtra("user_name",nome)
            startActivity(i)
        }

    }
}