package com.vncmsk.puntosdeinteres.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class POIItem(

    @SerializedName("nombre")
    val nombre: String?,

    @SerializedName("descripcion")
    val descripcion: String?,

    @SerializedName("correo")
    val correo: String?,

    @SerializedName("telefono")
    val telefono: String?,

    @SerializedName("web")
    val web: String?,

    @SerializedName("ubicacion")
    val ubicacion: String?,

    @SerializedName("temperatura")
    val temperatura: String?,

    @SerializedName("actividades")
    val actividades: String?,

    @SerializedName("urlPicture")
    val urlPicture: String?,

    @SerializedName("rate")
    val rate: Float?
) : Serializable