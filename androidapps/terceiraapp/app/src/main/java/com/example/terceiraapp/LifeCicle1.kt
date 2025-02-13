package com.example.terceiraapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.terceiraapp.databinding.ActivityLifeCicle1Binding

class LifeCicle1 : AppCompatActivity() {
    public val binding by lazy {
        ActivityLifeCicle1Binding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.bttLifeCicleGoToP2.setOnClickListener {
            startActivity(Intent(this,LifeCicle2::class.java))
        }

        binding.bttLifeCilceHome.setOnClickListener {
            startActivity(Intent(this,Menu::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}