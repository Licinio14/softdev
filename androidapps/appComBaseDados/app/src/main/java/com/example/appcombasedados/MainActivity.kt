package com.example.appcombasedados

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.appcombasedados.bd.DBHelper
import com.example.appcombasedados.databinding.ActivityMainBinding
import com.example.appcombasedados.views.LoginActivity

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val db = DBHelper(this)

        val listaUtilizadores = db.utilizadorListSelectAll()

        binding.listViewExBdShowUsers.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaUtilizadores)



        binding.bttMainLogin.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()

        val db = DBHelper(this)

        val listaUtilizadores = db.utilizadorListSelectAll()

        binding.listViewExBdShowUsers.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaUtilizadores)

    }
}