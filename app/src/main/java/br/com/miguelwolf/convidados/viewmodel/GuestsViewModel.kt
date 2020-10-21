package br.com.miguelwolf.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.miguelwolf.convidados.service.constants.GuestConstants
import br.com.miguelwolf.convidados.service.model.GuestModel
import br.com.miguelwolf.convidados.service.repository.GuestRepository

class GuestsViewModel(application: Application) : AndroidViewModel(application) {

    private val mGuestRepository = GuestRepository(application.applicationContext)

    private val mGuestList = MutableLiveData<List<GuestModel>>()
    val guestList: LiveData<List<GuestModel>> = mGuestList

    fun load(filter: Int) {
        if (filter == GuestConstants.FILTER.PRESENT) {
            mGuestList.value = mGuestRepository.getPresent()
        } else if (filter == GuestConstants.FILTER.ABSENT) {
            mGuestList.value = mGuestRepository.getAbsent()
        } else {
            mGuestList.value = mGuestRepository.getAll()
        }
    }

    fun delete(id: Int){
        val guest = mGuestRepository.get(id)
        mGuestRepository.delete(guest)
    }
}