package com.example.examenyanethdez.adapter

import android.content.DialogInterface.OnClickListener
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examenyanethdez.R

class AplicacionesAdapter(private val aplicacionesAmazonList: List<Aplicaciones>,
                         private val  onClickListener: (Aplicaciones)->Unit):RecyclerView.Adapter<AplicacionesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AplicacionesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AplicacionesViewHolder(layoutInflater.inflate(R.layout.item_aplicaciones,parent,false))
    }
    override fun getItemCount(): Int = aplicacionesAmazonList.size

    override fun onBindViewHolder(holder: AplicacionesViewHolder, position: Int) {
       val item = aplicacionesAmazonList[position]
        holder.render(item, onClickListener)
    }
}