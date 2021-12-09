package com.vncmsk.puntosdeinteres.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.vncmsk.puntosdeinteres.databinding.FragmentDetailBinding
import com.vncmsk.puntosdeinteres.ui.main.MainActivity

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
      descripcionTextView.text = punto.descripcion
      telefonoTextView.text = punto.telefono
      webTextView.text = punto.web
      ubicacionTextView.text = punto.ubicacion
      temperaturaTextView.text = punto.temperatura
      actividadesTextView.text = punto.actividades
      com.squareup.picasso.Picasso.get().load(punto.urlPicture).into(sitioImageView)

      mapButton.setOnClickListener{
      findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToMapsFragment(puntoInteres = punto))
      }
    }
  }
}