package com.example.terceiraapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.terceiraapp.databinding.ActivityMostrarContasPrimeiroSegundoNumeroBinding

class MostrarContasPrimeiroSegundoNumero : AppCompatActivity() {

    public val binding by lazy {
        ActivityMostrarContasPrimeiroSegundoNumeroBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val i = intent
        var num1 = i.extras?.getString("num1")?.toInt()
        var num2 = i.extras?.getString("num2")?.toInt()


        var soma = num1?.plus(num2!!)
        binding.mostrarSomaPS.text = "$num1 + $num2 = $soma"

        var dif = num1?.minus(num2!!)
        binding.mostrarSubtracaoPS.text = "$num1 - $num2 = $dif"

        var mult = num1?.times(num2!!)
        binding.mostrarMultiplicacaoPS.text = "$num1 * $num2 = $mult"

        var div = num1?.div(num2!!)
        binding.mostrarDivisaoPS.text= "$num1 / $num2 = $div"


        binding.bttMostrarOperacoesHome.setOnClickListener {
            startActivity(Intent(this,Menu::class.java))
        }



    }
}