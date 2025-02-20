package com.example.appcombasedados.views

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.appcombasedados.bd.DBHelper
import com.example.appcombasedados.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.bttLoginRegistar.setOnClickListener {
            startActivity(Intent(this,RegistoActivity::class.java))
        }

        binding.bttLoginEntrar.setOnClickListener {
            val name = binding.inputLoginUsername.text.toString()
            val pass = binding.inputLoginPassword.text.toString()

            val db = DBHelper(this)


            var verificar = db.utilizadorVerificar(name,pass)

            if (verificar != -1){

                val i = Intent(this,MinhaContaActivity::class.java)
                i.putExtra("id", verificar.toString())
                startActivity(i)


            }else {
                Toast.makeText(this,"Credenciais erradas!",Toast.LENGTH_SHORT).show()
            }

        }


    }
}