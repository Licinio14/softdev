package com.example.terceiraapp.views

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.terceiraapp.databinding.ActivitySplashBinding


class splash : AppCompatActivity() {

    private val binding by lazy {
        ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            binding.labelCarregando.text = "\uD83D\uDD5B"
        },500)

        Handler(Looper.getMainLooper()).postDelayed({
            binding.labelCarregando.text = "\uD83D\uDD52"
        },1000)

        Handler(Looper.getMainLooper()).postDelayed({
            binding.labelCarregando.text = "\uD83D\uDD5E"
        },1500)

        Handler(Looper.getMainLooper()).postDelayed({
            binding.labelCarregando.text = "\uD83D\uDD64"
        },2000)

        Handler(Looper.getMainLooper()).postDelayed({
            binding.labelCarregando.text = "\uD83D\uDD58"
        },2500)

        Handler(Looper.getMainLooper()).postDelayed({
            binding.labelCarregando.text = "\uD83D\uDD5B"
        },3000)

        Handler(Looper.getMainLooper()).postDelayed({
            binding.labelCarregando.text = "\uD83D\uDD52"
        },3500)

        Handler(Looper.getMainLooper()).postDelayed({
            binding.labelCarregando.text = "\uD83D\uDD5E"
        },4000)

        Handler(Looper.getMainLooper()).postDelayed({
            binding.labelCarregando.text = "\uD83D\uDD64"
        },4500)

        Handler(Looper.getMainLooper()).postDelayed({
            binding.labelCarregando.text = "\uD83D\uDD58"
        },5000)

        Handler(Looper.getMainLooper()).postDelayed({
            binding.labelCarregando.text = "\uD83D\uDD5B"
        },5500)


        /*
        var carregamento: String = ""
        var tempo: Long = 1

        for (i in 1 .. 6){
            tempo = (i * 833).toLong()
            Handler(Looper.getMainLooper()).postDelayed({
                carregamento += "☣"
                binding.labelCarregando.text = carregamento
            },tempo)
        }
        */


        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
        },5700)


    }
}