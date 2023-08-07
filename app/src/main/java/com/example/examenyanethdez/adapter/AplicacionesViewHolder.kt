package com.example.examenyanethdez.adapter

import android.view.View
import android.widget.SimpleAdapter.ViewBinder
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.RecyclerListener
import com.bumptech.glide.Glide
import com.example.examenyanethdez.AplicacionesAmazon
import com.example.examenyanethdez.R
import com.example.examenyanethdez.databinding.ItemAplicacionesBinding

class AplicacionesViewHolder(view:View): RecyclerView.ViewHolder(view){
    val vBind = ItemAplicacionesBinding.bind(itemView)

    fun render(aplicacionesAmazon: Aplicaciones,   onClickListener: (Aplicaciones)->Unit){
        vBind.tvName.text= aplicacionesAmazon.nombre
        vBind.tvDesarrollador.text = aplicacionesAmazon.nombreDesarrollador
        if((aplicacionesAmazon.costo.toDoubleOrNull() ?: 0.0) < 0.5){
            vBind.tvCosto.text ="FREE"
        }else{
            vBind.tvCosto.text = "$" + aplicacionesAmazon.costo
        }

        Glide.with(vBind.ivApp.context).load(aplicacionesAmazon.photo).into(vBind.ivApp)
        itemView.setOnClickListener { onClickListener(aplicacionesAmazon) }

    }
}