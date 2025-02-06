package com.example.terceiraapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.terceiraapp.databinding.ActivityPedirInformacoesUserBinding

class PedirInformacoesUser : AppCompatActivity() {

    private val binding by lazy {
        ActivityPedirInformacoesUserBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.bttPedirInformacoesVoltarHome.setOnClickListener {
            startActivity(Intent(this,Menu::class.java))
        }

        binding.bttEnviarInformacao.setOnClickListener {
            var nome = binding.pedirInformacaoNome.text.toString()
            var rua = binding.pedirInformacaoRua.text.toString()
            var telefone = binding.pedirInformacaoTelefone.text.toString()
            var email = binding.pedirInformacaoEmail.text.toString()
            var genero = ""
            if (binding.pedirInformacaoGenero.isChecked){
                genero = "M"
            }else{
                genero = "F"
            }


            val i = Intent(this,MostrarInformacoesUser::class.java)
            i.putExtra("nome",nome)
            i.putExtra("rua",rua)
            i.putExtra("telefone",telefone)
            i.putExtra("email",email)
            i.putExtra("genero",genero)
            startActivity(i)

        }

    }
}