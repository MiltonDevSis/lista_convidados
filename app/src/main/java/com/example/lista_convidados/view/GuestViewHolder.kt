package com.example.lista_convidados.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lista_convidados.R
import com.example.lista_convidados.listener.GuestListener
import com.example.lista_convidados.service.model.GuestModel

class GuestViewHolder(itemView: View, private val listener: GuestListener) : RecyclerView.ViewHolder(itemView) {

    fun bind(guest: GuestModel) {

        val textName = itemView.findViewById<TextView>(R.id.textName)
        textName.text = guest.nome

        textName.setOnClickListener {
            listener.onClick(guest.id)
        }
    }
}