package com.example.cocomminticapppuntosinteres


import com.google.gson.annotations.SerializedName

data class POIItem(
    @SerializedName("descripcion")
    val descripcion: String?,
    @SerializedName("nombre")
    val nombre: String?,
    @SerializedName("urlPicture")
    val urlPicture: String?,
    @SerializedName("rate")
    val rate: Float?
)