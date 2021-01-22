package com.example.lista_convidados.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AllGuestViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is all guest Fragment"
    }
    val text: LiveData<String> = _text
}