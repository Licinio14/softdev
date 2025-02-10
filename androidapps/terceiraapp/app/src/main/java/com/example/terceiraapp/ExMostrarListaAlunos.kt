package com.example.terceiraapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.terceiraapp.databinding.ActivityExMostrarListaAlunosBinding

class ExMostrarListaAlunos : AppCompatActivity() {

    public val bindind by lazy {
        ActivityExMostrarListaAlunosBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindind.root)

        val listaAlunos = ArrayList<Alunos>()

        listaAlunos.add(Alunos("Licinio","Rua 1","l@gmail.com"))
        listaAlunos.add(Alunos("Luis","Rua 2","ls@gmail.com"))
        listaAlunos.add(Alunos("Thiago","Rua 3","t@gmail.com"))
        listaAlunos.add(Alunos("Ana","Rua 4","A@gmail.com"))
        listaAlunos.add(Alunos("Marta","Rua 5","M@gmail.com"))

        bindind.listViewMostrarTodosAlunos.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,listaAlunos)


        bindind.listViewMostrarTodosAlunos.setOnItemClickListener { parent, view, position, id ->
            var aluno = listaAlunos.get(position).name
            var morada = listaAlunos.get(position).morada
            var email = listaAlunos.get(position).email

            val i = Intent(this,MostrarInformacaoDoAluno::class.java)
            i.putExtra("aluno",aluno)
            i.putExtra("morada", morada)
            i.putExtra("email",email)
            startActivity(i)
        }

        bindind.bttExMostrarAlunosHome.setOnClickListener {
            startActivity(Intent(this,Menu::class.java))
        }

    }
}