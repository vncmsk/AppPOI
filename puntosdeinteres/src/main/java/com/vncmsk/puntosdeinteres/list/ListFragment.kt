package com.vncmsk.puntosdeinteres.list

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.vncmsk.puntosdeinteres.databinding.FragmentListBinding
import com.vncmsk.puntosdeinteres.main.MainActivity
import com.vncmsk.puntosdeinteres.model.POI
import com.vncmsk.puntosdeinteres.model.POIItem

class ListFragment : Fragment() {

  private lateinit var listBinding: FragmentListBinding
  private lateinit var puntosAdapter: PuntosAdapter
  private lateinit var listPuntos: ArrayList<POIItem>

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    listBinding = FragmentListBinding.inflate(inflater, container, false)
    return listBinding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    (activity as MainActivity?)?.hideIcon()
    listPuntos = loadlistPuntosformJSON()
    puntosAdapter = PuntosAdapter(listPuntos, onItemClicked = { onPoiClicked(it) })

    listBinding.puntosRecyclerView.apply {
      layoutManager = LinearLayoutManager(context)
      adapter = puntosAdapter
      setHasFixedSize(false)
    }
  }

  private fun onPoiClicked(puntointer: POIItem) {
    findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(puntoInteres = puntointer))
  }

  private fun loadlistPuntosformJSON(): ArrayList<POIItem> {
    val puntosString: String = context?.assets?.open("sitios.json")?.bufferedReader().use { it!!.readText() }
    val gson = Gson()
    val data = gson.fromJson(puntosString,  POI::class.java)
    return data
  }
}


