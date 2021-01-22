package com.example.lista_convidados.ui.absent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AbsentViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is absent Fragment"
    }
    val text: LiveData<String> = _text
}