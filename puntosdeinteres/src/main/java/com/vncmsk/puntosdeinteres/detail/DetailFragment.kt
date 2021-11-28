package com.vncmsk.puntosdeinteres.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import com.vncmsk.puntosdeinteres.databinding.FragmentDetailBinding
import com.vncmsk.puntosdeinteres.main.MainActivity

class DetailFragment : Fragment() {

  private lateinit var detailBinding: FragmentDetailBinding
  private val args: DetailFragmentArgs by navArgs()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    (activity as MainActivity?)?.showIcon()
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    detailBinding = FragmentDetailBinding.inflate(inflater, container, false)

    return detailBinding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val punto = args.puntoInteres

    with (detailBinding) {
      tituloTextView.text = punto.nombre
      temperaturaTextView.text = punto.temperatura
      alturaTextView.text = punto.altura
      descripcionTextView.text = punto.descripcion
      actividadesTextView.text = punto.actividadesPoi
      com.squareup.picasso.Picasso.get().load(punto.urlPicture).into(sitioImageView)
    }
  }
}