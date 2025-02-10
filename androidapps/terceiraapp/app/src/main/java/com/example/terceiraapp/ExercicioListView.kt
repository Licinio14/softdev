package com.example.terceiraapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.terceiraapp.databinding.ActivityExercicioListViewBinding

class ExercicioListView : AppCompatActivity() {

    public val binding by lazy {
        ActivityExercicioListViewBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val lista = ArrayList<String>()

        binding.listViewEx7.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,lista)

        binding.bttAdicionarAListView.setOnClickListener {
            var num = binding.inputNumeroParaListView.text.toString()
            lista.add(num)
            binding.listViewEx7.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,lista)
            binding.inputNumeroParaListView.text = null
        }

        binding.listViewEx7.setOnItemClickListener { parent, view, position, id ->
                Toast.makeText(this,"Clicado em ${lista.get(position)}", Toast.LENGTH_SHORT).show()
        }

        binding.bttExListViewVoltarHome.setOnClickListener {
            startActivity(Intent(this,Menu::class.java))
        }

    }
}