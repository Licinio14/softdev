package com.example.terceiraapp.views

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.terceiraapp.R
import com.example.terceiraapp.databinding.ActivityPlayerDeSonsBinding

class PlayerDeSons : AppCompatActivity() {
    public val binding by lazy {
        ActivityPlayerDeSonsBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.bttPlaySom1.setOnClickListener {
            val mediaPlayer = MediaPlayer.create(applicationContext, R.raw.audio1)
            mediaPlayer.start()
        }

        binding.bttPlaySom2.setOnClickListener {
            val mediaPlayer = MediaPlayer.create(applicationContext, R.raw.audio2)
            mediaPlayer.start()
        }

        binding.bttPlaySom3.setOnClickListener {
            val mediaPlayer = MediaPlayer.create(applicationContext, R.raw.audio3)
            mediaPlayer.start()
        }

        binding.bttPlaySom4.setOnClickListener {
            val mediaPlayer = MediaPlayer.create(applicationContext, R.raw.audio4)
            mediaPlayer.start()
        }

        binding.bttPlayerSonsHome.setOnClickListener {
            startActivity(Intent(this, Menu::class.java))
        }

    }
}