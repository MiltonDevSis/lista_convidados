package com.example.lista_convidados.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lista_convidados.R
import com.example.lista_convidados.view.adapter.GuestAdapter
import com.example.lista_convidados.viewmodel.AllGuestViewModel
import kotlinx.android.synthetic.main.fragment_all_guest.*

class AllGuestFragment : Fragment() {

    private lateinit var all_guest_ViewModel: AllGuestViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        all_guest_ViewModel = ViewModelProvider(this).get(AllGuestViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_all_guest, container, false)

        //RecyclerView
        //1 - obter o recycler
        val recycler: RecyclerView = root.findViewById(R.id.recycler_All_Guests)

        //2 - definir um layout
        recycler.layoutManager = LinearLayoutManager(context)

        //3 - definir um adapter
        recycler.adapter = GuestAdapter()

        return root
    }
}