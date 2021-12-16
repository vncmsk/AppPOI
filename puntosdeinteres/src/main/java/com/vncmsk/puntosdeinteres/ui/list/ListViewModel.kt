package com.vncmsk.puntosdeinteres.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vncmsk.puntosdeinteres.data.PuntosRepository
import com.vncmsk.puntosdeinteres.model.POIItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {

    private var puntosLoad: MutableLiveData<ArrayList<POIItem>> = MutableLiveData()
    val onPuntosLoaded:LiveData<ArrayList<POIItem>> = puntosLoad

    private val repository = PuntosRepository()

    fun getPuntosFromServer(){
        GlobalScope.launch(Dispatchers.IO){
            puntosLoad.postValue(repository.getPuntos())
        }
    }
}