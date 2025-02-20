package com.example.terceiraapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.terceiraapp.R
import com.example.terceiraapp.model.Carro

class CarroListAdapter(val listaDeCarros: ArrayList<Carro>, val clickListener: onClickListener): RecyclerView.Adapter<CarroListAdapter.CarroViewHolder>() {

    var contadorOnCreate = 0
    var contadorOnBind = 0


    class CarroViewHolder (ItemView : View) : RecyclerView.ViewHolder(ItemView){
        val textView = itemView.findViewById<TextView>(R.id.text_modelo)
    }

    class onClickListener (val clickListener: (carro: Carro) -> Unit){
        fun onClick(carro: Carro) = clickListener(carro)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarroViewHolder {
        contadorOnCreate++
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_carro_list,parent,false)

        return CarroViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  listaDeCarros.size
    }

    override fun onBindViewHolder(holder: CarroViewHolder, position: Int) {
        contadorOnBind++
        val carro = listaDeCarros[position]

        holder.textView.setText(carro.modelo)
        holder.itemView.setOnClickListener {
            clickListener.onClick(carro)
        }
    }

}