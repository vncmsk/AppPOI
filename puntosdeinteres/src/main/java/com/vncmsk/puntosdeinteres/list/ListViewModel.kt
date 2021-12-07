package com.vncmsk.puntosdeinteres.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.vncmsk.puntosdeinteres.model.POI
import com.vncmsk.puntosdeinteres.model.POIItem
import java.io.InputStream

class ListViewModel : ViewModel() {

    private var puntosLoad: MutableLiveData<ArrayList<POIItem>> = MutableLiveData()
    val onPuntosLoaded:LiveData<ArrayList<POIItem>> = puntosLoad

    fun loadListPuntosfromJSON(puntosString: InputStream?){
        val puntosString = puntosString?.bufferedReader().use {it!!.readText()}
        val gson = Gson()
        puntosLoad.value = gson.fromJson(puntosString, POI::class.java)

    }
}