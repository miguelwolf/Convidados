package br.com.miguelwolf.convidados.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.miguelwolf.convidados.R
import br.com.miguelwolf.convidados.viewmodel.AllGuestsViewModel

class AbsentFragment : Fragment() {

    private lateinit var mViewModelAll: AllGuestsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewModelAll = ViewModelProvider(this).get(AllGuestsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_absent, container, false)
        val textView: TextView = root.findViewById(R.id.text_slideshow)
//        mViewModelAll.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }
}