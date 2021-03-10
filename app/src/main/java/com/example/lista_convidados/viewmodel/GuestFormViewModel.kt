package com.example.lista_convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lista_convidados.service.model.GuestModel
import com.example.lista_convidados.service.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {

    private val mContext = application.applicationContext
    private val mGuestRepository: GuestRepository = GuestRepository.getInstance(mContext)

    private var mSaveGuest = MutableLiveData<Boolean>()
    val saveGuest: LiveData<Boolean> = mSaveGuest

    private var mGuest = MutableLiveData<GuestModel>()
    val guest: LiveData<GuestModel> = mGuest

    fun save(id: Int, nome: String, presence: Boolean){
        val guest = GuestModel(id, nome, presence)

        if (id == 0){
            mSaveGuest.value = mGuestRepository.save(guest)
        }else {
            mSaveGuest.value = mGuestRepository.update(guest)
        }
        mGuestRepository.update(guest)
        mSaveGuest.value = mGuestRepository.save(guest)
    }

    fun load(id: Int){
        mGuest.value = mGuestRepository.get(id)
    }
}