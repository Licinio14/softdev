package com.example.appcombasedados.views

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appcombasedados.MainActivity
import com.example.appcombasedados.bd.DBHelper
import com.example.appcombasedados.databinding.ActivityMinhaContaBinding

class MinhaContaActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMinhaContaBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val i = intent


        var id = i.extras!!.getString("id")!!.toInt()

        val db = DBHelper(this)

        val uti = db.utilizadorObjectSelectById(id)

        var nome = uti.username.toString()

        var pass = uti.password.toString()

        binding.textViewUsarnameShow.setText(nome)

        binding.textviewPasswordShow.setText(pass)

        binding.bttAlterarUser.setOnClickListener {
            nome = binding.textViewUsarnameShow.text.toString()
            pass = binding.textviewPasswordShow.text.toString()

            db.utilizadorUpdate(id,nome,pass)

            Toast.makeText(this,"Informação modificada",Toast.LENGTH_SHORT).show()

        }

        binding.bttEliminarUser.setOnClickListener {
            db.utilizadorDelete(id)

            Toast.makeText(this,"Utilizador eliminado!",Toast.LENGTH_SHORT).show()

            startActivity(Intent(this,MainActivity::class.java))
        }






    }
}