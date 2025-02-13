package com.example.terceiraapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.terceiraapp.databinding.ActivityInserirNotasBinding

class InserirNotas : AppCompatActivity() {

    public val binding by lazy {
        ActivityInserirNotasBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val sharedPreferences = this.getSharedPreferences("notas", Context.MODE_PRIVATE)
        val nota = sharedPreferences.getString("nota","").toString()
        var textoAntigo: String = nota


        binding.bttInserirNotasVoltar.setOnClickListener {
            startActivity(Intent(this,MenuBlocoNotas::class.java))
        }

        binding.bttInserirNostas.setOnClickListener {
            var textoNota: String = binding.inputInserirNotas.text.toString()

            if (textoNota.trim().length > 5){
                textoAntigo += textoNota + ";"
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString("nota",textoAntigo)
                editor.apply()
                Toast.makeText(this,"A nota foi adicionada com sucesso!",Toast.LENGTH_SHORT).show()

            }else{
                Toast.makeText(this,"A nota tem de ter mais de 5 caracteres!",Toast.LENGTH_SHORT).show()
            }

        }

    }
}