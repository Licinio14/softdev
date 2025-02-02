package com.example.a01_primeiraapp

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.setPadding
import com.example.a01_primeiraapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btt1.setOnClickListener {
            if (binding.nameText.text.toString().isEmpty() || binding.surnameText.text.toString().isEmpty()){
                Toast.makeText(this, "Tem de preencher todos os campos!", Toast.LENGTH_SHORT).show()
            }else {
                var name: String = binding.nameText.text.toString()
                var surname: String = binding.surnameText.text.toString()

                var completeName = "Olá $name $surname"
                // binding.resultado.text = completeName

                Toast.makeText(this, completeName, Toast.LENGTH_SHORT).show()
            }


        }
    }
}