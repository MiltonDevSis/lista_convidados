package com.example.lista_convidados.ui.all_guest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.lista_convidados.R

class AllGuestFragment : Fragment() {

    private lateinit var all_guest_ViewModel: AllGuestViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        all_guest_ViewModel =
                ViewModelProvider(this).get(AllGuestViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_all_guest, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        all_guest_ViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}