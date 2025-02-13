package com.example.terceiraapp

import android.R
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.terceiraapp.databinding.ActivityVerNotasBinding

class VerNotas : AppCompatActivity() {

    public val binding by lazy {
        ActivityVerNotasBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val sharedPreferences = this.getSharedPreferences("notas", Context.MODE_PRIVATE)
        val nota = sharedPreferences.getString("nota","").toString()
        var texto: String = nota


        val lista = texto.split(";") as ArrayList<String>

        if (texto != ""){

            binding.listViewMostrarNotas.adapter = ArrayAdapter(this, R.layout.simple_list_item_1,lista)
        }



        binding.bttVerNotasVoltar.setOnClickListener {
            startActivity(Intent(this,MenuBlocoNotas::class.java))
        }

        binding.listViewMostrarNotas.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this,"Apagada a nota ${lista.get(position)}", Toast.LENGTH_SHORT).show()
            lista.removeAt(position)
            binding.listViewMostrarNotas.adapter = ArrayAdapter(this, R.layout.simple_list_item_1,lista)

            var novotexto = lista.joinToString(";")

            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("nota",novotexto)
            editor.apply()

        }

        binding.bttVerNotasLimpar.setOnClickListener {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.remove("nota")
            editor.apply()

            lista.clear()

            binding.listViewMostrarNotas.adapter = ArrayAdapter(this, R.layout.simple_list_item_1,lista)
        }
    }
}