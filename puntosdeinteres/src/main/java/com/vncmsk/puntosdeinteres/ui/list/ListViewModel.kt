package com.vncmsk.puntosdeinteres.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.vncmsk.puntosdeinteres.data.PuntosRepository
import com.vncmsk.puntosdeinteres.model.POI
import com.vncmsk.puntosdeinteres.model.POIItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream

class ListViewModel : ViewModel() {

    private var puntosLoad: MutableLiveData<ArrayList<POIItem>> = MutableLiveData()
    val onPuntosLoaded:LiveData<ArrayList<POIItem>> = puntosLoad

    private val repository = PuntosRepository()

    fun getPuntosFromServer(){
        GlobalScope.launch(Dispatchers.IO){
            puntosLoad.postValue(repository.getPuntos())
        }
    }

    fun loadListPuntosfromJSON(puntosString: InputStream?){
        val puntosString = puntosString?.bufferedReader().use {it!!.readText()}
        val gson = Gson()
        puntosLoad.value = gson.fromJson(puntosString, POI::class.java)
    }
}