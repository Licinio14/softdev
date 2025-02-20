package com.example.terceiraapp.data

import com.example.terceiraapp.model.Carro

class CarroMock {
    var listaDeCarros = ArrayList<Carro>()

    init {
        for (i in 1 .. 100){
            listaDeCarros.add(Carro(i,"Modelo $i"))
        }
    }

}