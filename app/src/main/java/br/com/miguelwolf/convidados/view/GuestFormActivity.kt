package br.com.miguelwolf.convidados.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.miguelwolf.convidados.viewmodel.GuestFormViewModel
import br.com.miguelwolf.convidados.R
import br.com.miguelwolf.convidados.service.constants.GuestConstants
import kotlinx.android.synthetic.main.activity_guest_form.*

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: GuestFormViewModel
    private var mGuestId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_form)

        mViewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        setListeners()
        observe()
        loadData()

        radiobutton_present.isChecked = true
    }

    override fun onClick(v: View) {

        val id = v.id

        if (id == R.id.button_save){

            val name = edittext_name.text.toString()
            val presence = radiobutton_present.isChecked

            mViewModel.save(mGuestId, name, presence)
        }

    }

    private fun setListeners() {
        button_save.setOnClickListener(this)
    }

    private fun loadData(){
        val bundle = intent.extras
        if (bundle != null) {
            mGuestId = bundle.getInt(GuestConstants.GUESTID)
            mViewModel.load(mGuestId)
        }
    }

    private fun observe() {
        mViewModel.saveGuest.observe(this, Observer {
            if (it) {
                Toast.makeText(applicationContext, getString(R.string.success), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, getString(R.string.fail), Toast.LENGTH_SHORT).show()
            }
            finish()
        })

        mViewModel.guest.observe(this, Observer {
            edittext_name.setText(it.name)
            if (it.presence) {
                radiobutton_present.isChecked = true
            } else {
                radiobutton_absent.isChecked = true
            }
        })

    }


}