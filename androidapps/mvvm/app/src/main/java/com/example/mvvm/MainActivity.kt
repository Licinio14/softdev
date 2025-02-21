package com.example.mvvm

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)




        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
/*
        viewModel.welcome().observe(this, Observer {
            binding.textWelcome.text = it
        })

         */

        

        viewModel.login().observe(this, Observer {
            if (it){
                Toast.makeText(this,"Login OK", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Login Erro", Toast.LENGTH_SHORT).show()
            }
        })


        binding.buttonEntrar.setOnClickListener {
            val email = binding.editEmail.text.toString()
            val senha = binding.editPassword.text.toString()

            viewModel.doLogin(email,senha)
        }

    }
}