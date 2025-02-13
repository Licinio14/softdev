package com.example.terceiraapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.terceiraapp.databinding.ActivityMenuBlocoNotasBinding

class MenuBlocoNotas : AppCompatActivity() {

    public val binding by lazy {
        ActivityMenuBlocoNotasBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.bttInserirNotas.setOnClickListener {
            startActivity(Intent(this,InserirNotas::class.java))
        }

        binding.bttMenuNotasHome.setOnClickListener {
            startActivity(Intent(this,Menu::class.java))
        }

        binding.bttVerNotas.setOnClickListener {
            val sharedPreferences = this.getSharedPreferences("notas", Context.MODE_PRIVATE)
            val nota = sharedPreferences.getString("nota","").toString()
            var texto: String = nota

            if (texto != ""){
                startActivity(Intent(this,VerNotas::class.java))
            }else{
                Toast.makeText(this,"Não existe notas para serem mostradas!",Toast.LENGTH_SHORT).show()
            }


        }
    }
}