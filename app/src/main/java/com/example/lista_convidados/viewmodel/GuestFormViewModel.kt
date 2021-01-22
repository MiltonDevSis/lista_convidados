package com.example.lista_convidados.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lista_convidados.service.model.GuestModel
import com.example.lista_convidados.service.repository.GuestRepository

class GuestFormViewModel : ViewModel() {

    private val mGuestRepository: GuestRepository =
        GuestRepository()

    private var mSaveGuest = MutableLiveData<Boolean>()
    val saveGuest: LiveData<Boolean> = mSaveGuest

    fun save(nome: String, presence: Boolean){
        val guest =
            GuestModel(nome, presence)
        mGuestRepository.save(guest)
    }
}