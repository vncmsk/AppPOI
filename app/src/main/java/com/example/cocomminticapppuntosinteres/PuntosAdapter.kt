package com.example.cocomminticapppuntosinteres

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class PuntosAdapter(private val puntosList: ArrayList<POIItem>) :
  RecyclerView.Adapter<PuntosAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_punto_item, parent, false)
    return ViewHolder(view)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val POI = puntosList[position]
    holder.bind(POI)
  }

  override fun getItemCount(): Int = puntosList.size

  class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var nameTextView: TextView = itemView.findViewById(R.id.name_text_view)
    private var aliasTextView: TextView = itemView.findViewById(R.id.descripcion_text_view)
    private var pictureImageView: ImageView = itemView.findViewById(R.id.picture_image_view)
    private var rateRatingBar: RatingBar = itemView.findViewById(R.id.puntaje_ratingbar)

    fun bind(puntoInteres: POIItem){
      nameTextView.text = puntoInteres.nombre
      aliasTextView.text = puntoInteres.descripcion
      Picasso.get().load(puntoInteres.urlPicture).into(pictureImageView);
      rateRatingBar.rating = puntoInteres.rate!!
    }
  }
}