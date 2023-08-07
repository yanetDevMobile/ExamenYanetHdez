package com.example.examenyanethdez

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.example.examenyanethdez.adapter.Aplicaciones
import com.example.examenyanethdez.adapter.AplicacionesAdapter
import com.example.examenyanethdez.adapter.AplicacionesProvider
import com.example.examenyanethdez.databinding.ActivityMainBinding
import com.google.gson.Gson
import java.io.IOException


class MainActivity : AppCompatActivity() {

    private val spCategories : Spinner? = null
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val gson = Gson()
        val json = loadData("aplicaciones.json")
        Log.d("RES", json)
        val aplicaciones = listOf(gson.fromJson(json, Response::class.java))

        val categories = arrayOf("Categoria"," Categoria1", "Categoria2", "Categoria3")




        initRecyclerView()

        val adaptador: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_spinner_item,categories)
        binding.spCategorias.adapter= adaptador

        spCategories?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

    }

    fun initRecyclerView(){
        val manager = GridLayoutManager(this, 3)
        val decoration = DividerItemDecoration(this, manager.orientation)
        val recyclerView = binding.rvAplicaciones
        recyclerView.layoutManager = manager
        recyclerView.adapter = AplicacionesAdapter(AplicacionesProvider.aplicaciones){onItemSelected(it)}
        binding.rvAplicaciones.addItemDecoration(decoration)

    }

    fun onItemSelected(aplicaciones: Aplicaciones){
        val intent = Intent(this, DetalleActivity::class.java)
        intent.putExtra("name",aplicaciones.nombre)
        intent.putExtra("url", aplicaciones.photo)
        intent.putExtra("costo", aplicaciones.costo)
        startActivity(intent)
        //Toast.makeText(this, aplicaciones.categoria, Toast.LENGTH_LONG).show()

    }
    fun loadData(inFile:String):String{
        var tContens = ""
        try {
            val stream = assets.open(inFile)
            val size = stream.available()
            val buffer = ByteArray(size)
            stream.read(buffer)
            stream.close()
            tContens= String(buffer)
        }catch (e:IOException){

        }
        return tContens
    }



}