package com.vncmsk.puntosdeinteres.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.vncmsk.puntosdeinteres.R
import com.vncmsk.puntosdeinteres.model.POIItem

class PuntosAdapter(
  private val puntosList: ArrayList<POIItem>,
  private val onItemClicked: (POIItem) -> Unit) :
  RecyclerView.Adapter<PuntosAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view =
      LayoutInflater.from(parent.context).inflate(R.layout.card_view_punto_item, parent, false)
    return ViewHolder(view)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val poi = puntosList[position]
    holder.itemView.setOnClickListener {onItemClicked(puntosList[position])}
    holder.bind(poi)
  }

  override fun getItemCount(): Int = puntosList.size

  class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var nameTextView: TextView = itemView.findViewById(R.id.name_text_view)
    private var descripcionTextView: TextView = itemView.findViewById(R.id.descripcion_text_view)
    private var pictureImageView: ImageView = itemView.findViewById(R.id.picture_image_view)
    private var rateTextView: TextView = itemView.findViewById(R.id.rateTextView)
    private var rateRatingBar: RatingBar = itemView.findViewById(R.id.puntaje_ratingbar)

    fun bind(puntoInteres: POIItem) {
      nameTextView.text = puntoInteres.nombre
      descripcionTextView.text = puntoInteres.descripcion
      Picasso.get().load(puntoInteres.urlPicture).into(pictureImageView);
      rateTextView.text = puntoInteres.rate.toString()
      rateRatingBar.rating = puntoInteres.rate!!
    }
  }
}