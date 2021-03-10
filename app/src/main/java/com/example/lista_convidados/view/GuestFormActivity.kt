package com.example.lista_convidados.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.lista_convidados.viewmodel.GuestFormViewModel
import com.example.lista_convidados.R
import com.example.lista_convidados.service.constants.GuestConstants
import com.google.android.material.textfield.TextInputEditText
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_guest_form.*
import kotlinx.android.synthetic.main.raw_guest.*

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: GuestFormViewModel
    val btnSalvar = findViewById<Button>(R.id.btnSalvar)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_form)

        mViewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        loadData()
        setListeners()
        observe()
    }

    override fun onClick(view: View) {
        when (view.id){
            R.id.btnSalvar -> {

                val edtNome = findViewById<TextInputEditText>(R.id.edtNome)
                val presente = findViewById<RadioButton>(R.id.radioPresente).isChecked

                val nome = edtNome.text.toString()

                mViewModel.save(nome, presente)
            }
        }
    }

    private fun loadData(){
        val bundle = intent.extras

        if (bundle != null){
            val id = bundle.getInt(GuestConstants.GUESTID)
            // carregar
            mViewModel.load(id)
        }
    }

    fun observe(){
        mViewModel.saveGuest.observe(this, Observer {
            if (it){
                Toasty.success(this, "Sucesso", Toasty.LENGTH_LONG).show()
            }else{
                Toasty.error(this, "Falha", Toasty.LENGTH_LONG).show()
            }
            finish()
        })

        mViewModel.guest.observe(this, Observer {
            edtNome.setText(it.nome)
            if (it.presence){
                radioPresente.isChecked = true
            } else{
                radioAusente.isChecked = true
            }
        })
    }

    private fun setListeners(){
        btnSalvar.setOnClickListener(this)
    }
}