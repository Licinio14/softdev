package com.example.terceiraapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.terceiraapp.databaseclasses.UsuarioManager
import com.example.terceiraapp.databinding.ActivityRegistarUtilizadorBinding
import kotlinx.coroutines.launch

class RegistarUtilizador : AppCompatActivity() {

    public val binding by lazy {
        ActivityRegistarUtilizadorBinding.inflate(layoutInflater)
    }

    private lateinit var usuarioManager: UsuarioManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        usuarioManager = UsuarioManager(this)




        binding.bttAdicionarUsuario.setOnClickListener {

            if (binding.inputNameCriarUsuario.text.toString().isEmpty() || binding.inputPassCriarUsuario.text.toString().isEmpty()){
                Toast.makeText(this@RegistarUtilizador, "Precisa preencher os campos!", Toast.LENGTH_SHORT).show()
            }else{
                // Exemplo de uso com Coroutines
                lifecycleScope.launch {
                    // Cadastrar novo usuário
                    val cadastroSucesso = usuarioManager.cadastrarUsuario(binding.inputNameCriarUsuario.text.toString(), binding.inputPassCriarUsuario.text.toString())
                    Toast.makeText(this@RegistarUtilizador, "Registado com sucesso!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@RegistarUtilizador,MainActivity::class.java)
                    startActivity(intent)

                }
            }


        }


    }
}