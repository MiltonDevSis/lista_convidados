package com.example.lista_convidados.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lista_convidados.R
import com.example.lista_convidados.listener.GuestListener
import com.example.lista_convidados.service.model.GuestModel
import com.example.lista_convidados.view.GuestViewHolder

class GuestAdapter : RecyclerView.Adapter<GuestViewHolder>() {

    private var mGuestList: List<GuestModel> = arrayListOf()
    private lateinit var mListener: GuestListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {

        val item = LayoutInflater.from(parent.context).inflate(R.layout.raw_guest, parent, false)
        return GuestViewHolder(item, mListener)
    }

    override fun getItemCount(): Int {
       return mGuestList.count()
    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        holder.bind(mGuestList[position])
    }

    fun updateGuests(lista: List<GuestModel>) {
        mGuestList = lista
        notifyDataSetChanged()
    }

    fun attachListener(listener: GuestListener){
        mListener = listener
    }
}