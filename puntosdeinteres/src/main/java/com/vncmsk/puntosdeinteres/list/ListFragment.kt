package com.vncmsk.puntosdeinteres.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.vncmsk.puntosdeinteres.databinding.FragmentListBinding
import com.vncmsk.puntosdeinteres.main.MainActivity
import com.vncmsk.puntosdeinteres.model.POIItem

class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var puntosAdapter: PuntosAdapter
    private var listPuntosGlobal: ArrayList<POIItem> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()
        listViewModel.loadListPuntosfromJSON(context?.assets?.open("sitios.json"))
        listViewModel.onPuntosLoaded.observe(viewLifecycleOwner, { result ->
            onPuntosLoadedSuscribed(result)
        })

        puntosAdapter = PuntosAdapter(listPuntosGlobal, onItemClicked = { onPoiClicked(it) })
        listBinding.puntosRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = puntosAdapter
            setHasFixedSize(false)
        }
    }

    private fun onPuntosLoadedSuscribed(result: ArrayList<POIItem>?) {
        result?.let { listpuntoslocal ->

            puntosAdapter.appenditems(listpuntoslocal)
        }
    }

    private fun onPoiClicked(puntointer: POIItem) {
        findNavController().navigate(
            ListFragmentDirections.actionListFragmentToDetailFragment(
                puntoInteres = puntointer
            )
        )
    }
}


