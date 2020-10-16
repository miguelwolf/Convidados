package br.com.miguelwolf.convidados.view.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.miguelwolf.convidados.R
import br.com.miguelwolf.convidados.service.model.GuestModel
import kotlinx.android.synthetic.main.row_guest.view.*

class GuestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(guest: GuestModel) {
        val textname = itemView.findViewById<TextView>(R.id.text_name)
        textname.text = guest.name

    }

}