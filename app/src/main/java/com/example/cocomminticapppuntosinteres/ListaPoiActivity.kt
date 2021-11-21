package com.example.cocomminticapppuntosinteres

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class ListaPoiActivity : AppCompatActivity() {

  private lateinit var listPuntos: ArrayList<POIItem>
  private lateinit var puntosAdapter: PuntosAdapter
  private lateinit var puntosRecyclerView: RecyclerView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_lista_poi)

    puntosRecyclerView = findViewById(R.id.puntos_recycler_view)

    //listPuntos = crearPuntos()
    listPuntos = loadlistPuntosformJSON()
    puntosAdapter = PuntosAdapter(listPuntos)

    puntosRecyclerView.apply {
      layoutManager = LinearLayoutManager(context)
      adapter = puntosAdapter

      setHasFixedSize(false)
    }
  }

  private fun loadlistPuntosformJSON(): ArrayList<POIItem> {

    val puntosString: String = applicationContext.assets.open("sitios.json").bufferedReader().use { it.readText() }
    val gson = Gson()
    val data = gson.fromJson(puntosString,  POI::class.java)
    return data

  }
}