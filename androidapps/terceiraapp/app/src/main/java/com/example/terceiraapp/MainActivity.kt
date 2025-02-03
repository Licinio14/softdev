package com.example.terceiraapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.terceiraapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.bttEntrar.setOnClickListener{
            if (binding.textUsername.text.toString().isEmpty() || binding.textPassword.text.toString().isEmpty()){
                Toast.makeText(this, "Preencha todos os campos!!", Toast.LENGTH_SHORT).show()
            }else {
                if (binding.textUsername.text.toString() == "user" && binding.textPassword.text.toString() == "pass"){
                    val intent = Intent(this,Menu::class.java)
                    startActivity(intent)
                }else {
                    val intent = Intent(this,page1::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}