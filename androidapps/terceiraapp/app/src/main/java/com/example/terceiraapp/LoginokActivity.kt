package com.example.terceiraapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.terceiraapp.databinding.ActivityLoginokBinding

class LoginokActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLoginokBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.bttTestarParImparPrimo.setOnClickListener {
            var numero: Int = binding.parImparPrimoInput.text.toString().toInt()

            if ((numero % 2) == 0){
                binding.respostaParImpar.text = getString(R.string.par)
            }else {
                binding.respostaParImpar.text = getString(R.string.impar)
            }

            var primo: Boolean = true

            if (numero <= 1){
                primo = false
            }else if (numero == 2) {
                primo = true
            }else {
                for (i in 2 until numero){
                    if ((numero % i) == 0){
                        primo = false
                        break
                    }
                }
            }

            if (primo){
                binding.respostaPrimo.text = getString(R.string.primo)
            }else {
                binding.respostaPrimo.text = getString(R.string.naoprimo)
            }

        }

        binding.bttParPrimoHome.setOnClickListener {
            startActivity(Intent(this,Menu::class.java))
        }

    }
}