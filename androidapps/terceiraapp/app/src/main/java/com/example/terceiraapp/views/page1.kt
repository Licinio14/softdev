package com.example.terceiraapp.views

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.terceiraapp.databinding.ActivityPage1Binding

class page1 : AppCompatActivity() {

    private val binding by lazy {
        ActivityPage1Binding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Toast.makeText(this, "Login errado", Toast.LENGTH_LONG).show()

        binding.bttHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}