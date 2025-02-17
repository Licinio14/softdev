package com.example.terceiraapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.terceiraapp.databinding.ActivityMenuBinding

class Menu : AppCompatActivity() {

    private val binding by lazy {
        ActivityMenuBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var escolha: Int;
        val opcoes = ArrayList<String>()

        opcoes.add(getString(R.string.menu1))
        opcoes.add(getString(R.string.menu2))
        opcoes.add(getString(R.string.menu3))
        opcoes.add(getString(R.string.menu4))
        opcoes.add(getString(R.string.menu5))
        opcoes.add(getString(R.string.menu6))
        opcoes.add(getString(R.string.menu7))
        opcoes.add(getString(R.string.menu8))
        opcoes.add(getString(R.string.menu9))
        opcoes.add(getString(R.string.menu10))
        opcoes.add(getString(R.string.menu11))
        opcoes.add(getString(R.string.menu12))

        binding.listViewMenu.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,opcoes)


        binding.listViewMenu.setOnItemClickListener { parent, view, position, id ->
            escolha = position

            when (escolha) {
                0 -> startActivity(Intent(this,LoginokActivity::class.java))
                1 -> startActivity(Intent(this,CalcularSemanas::class.java))
                2 -> startActivity(Intent(this,exMudarNomeHome::class.java))
                3 -> startActivity(Intent(this,PedirInformacoesUser::class.java))
                4 -> startActivity(Intent(this,PedirPrimeiroNumero::class.java))
                5 -> startActivity(Intent(this,ExercicioListView::class.java))
                6 -> startActivity(Intent(this,ExMostrarListaAlunos::class.java))
                7 -> startActivity(Intent(this,MostrarPaginaExemplo::class.java))
                8 -> startActivity(Intent(this,MenuBlocoNotas::class.java))
                9 -> startActivity(Intent(this,LifeCicle1::class.java))
                10 -> startActivity(Intent(this,PlayerDeSons::class.java))
                11 -> startActivity(Intent(this,FullscreenActivity::class.java))
            }

        }

    }
}