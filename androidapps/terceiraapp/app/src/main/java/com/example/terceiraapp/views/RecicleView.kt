package com.example.terceiraapp.views

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.terceiraapp.adapter.CarroListAdapter
import com.example.terceiraapp.data.CarroMock
import com.example.terceiraapp.databinding.ActivityRecicleViewBinding

class RecicleView : AppCompatActivity() {
    private val binding by lazy {
        ActivityRecicleViewBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.recyclerViewPage.layoutManager = LinearLayoutManager(this)
        val car = CarroMock()
        binding.recyclerViewPage.adapter = CarroListAdapter(car.listaDeCarros, CarroListAdapter.onClickListener{ carro -> Toast.makeText(this,carro.modelo, Toast.LENGTH_SHORT).show()})

    }
}