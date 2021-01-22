package com.example.lista_convidados.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.example.lista_convidados.viewmodel.GuestFormViewModel
import com.example.lista_convidados.R

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: GuestFormViewModel
    val btnSalvar = findViewById<Button>(R.id.btnSalvar)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_form)

        mViewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        setListeners()
    }

    private fun setListeners(){
        btnSalvar.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id){
            R.id.btnSalvar -> {

            }
        }
    }
}