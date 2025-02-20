package com.example.appcombasedados.views

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.appcombasedados.bd.DBHelper
import com.example.appcombasedados.databinding.ActivityRegistoBinding

class RegistoActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityRegistoBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.bttRegisterSubmit.setOnClickListener {

            var name = binding.inputUserRegister.text.toString()

            var pass = binding.inputPassRegister.text.toString()

            if (name != "" && pass != ""){
                val db = DBHelper(this)

                db.utilizadorInsert(name,pass)
                Toast.makeText(this,"Utilizador registado com sucesso!",Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this,"Os campos sao de preenchimento obrigatorio!",Toast.LENGTH_SHORT).show()
            }

            startActivity(Intent(this,LoginActivity::class.java))
        }
    }
}