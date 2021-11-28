package com.vncmsk.puntosdeinteres.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class POIItem(
    @SerializedName("actividadesPoi")
    val actividadesPoi: String?,

    @SerializedName("descripcion")
    val descripcion: String?,

    @SerializedName("temperatura")
    val temperatura: String?,

    @SerializedName("altura")
    val altura: String?,

    @SerializedName("nombre")
    val nombre: String?,

    @SerializedName("urlPicture")
    val urlPicture: String?,

    @SerializedName("rate")
    val rate: Float?
) : Serializable