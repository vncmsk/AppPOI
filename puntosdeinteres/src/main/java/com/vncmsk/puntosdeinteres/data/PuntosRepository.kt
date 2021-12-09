package com.vncmsk.puntosdeinteres.data

class PuntosRepository {

  suspend fun getPuntos() = ApiFactory.retrofit.getpuntos()

}