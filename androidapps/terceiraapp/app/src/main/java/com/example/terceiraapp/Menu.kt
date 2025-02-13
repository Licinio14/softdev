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

        opcoes.add("Par e Primos")
        opcoes.add("Horas -> Semanas")
        opcoes.add("Passar Variaveis")
        opcoes.add("Pedir Informação")
        opcoes.add("Pedir numeros e calcular")
        opcoes.add("ListView")
        opcoes.add("Mostrar Alunos")
        opcoes.add("Mostrar uma Pagina exemplo")
        opcoes.add("Inserir e Ver notas")
        opcoes.add("Ciclo de vida da activity")
        opcoes.add("Player de sons")
        opcoes.add("Full screen")

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