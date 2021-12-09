package com.vncmsk.puntosdeinteres.data

import com.vncmsk.puntosdeinteres.model.POI
import retrofit2.http.GET

interface ApiService {

  @GET("/jsmarinn/appPuntosInteres/sitios")
  suspend fun getpuntos(): POI

}