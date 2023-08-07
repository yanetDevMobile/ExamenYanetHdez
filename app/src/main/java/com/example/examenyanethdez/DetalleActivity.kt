package com.example.examenyanethdez

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.examenyanethdez.databinding.ActivityDetalleBinding

class DetalleActivity:AppCompatActivity (){

    private lateinit var binding: ActivityDetalleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val nombre = bundle?.getString("name")
        val url = bundle?.getString("url")
        val costo = bundle?.getString("costo")
        Glide.with(binding.ivDetalleApp.context).load(url).into(binding.ivDetalleApp)
        binding.tvNameDetalle.text = nombre
        binding.tvCostoDetalle.text = "$$costo"
    }
}