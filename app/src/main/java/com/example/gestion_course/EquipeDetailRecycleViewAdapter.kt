package com.example.gestion_course

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gestion_course.entities.Equipe
import com.example.gestion_course.entities.Participant

class EquipeDetailRecycleViewAdapter( var participantList: List<Participant>) : RecyclerView.Adapter<EquipeDetailRecycleViewAdapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val viewHolder = LayoutInflater.from(parent.context)
                .inflate(R.layout.gridview_layout_equipe_detail, parent, false)
        return ItemHolder(viewHolder)
    }

    override fun getItemCount(): Int {
        return participantList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {



        val part: Participant = participantList[position]

        holder.prenom.text = part.nom_participant
        holder.niveau.text = part.niveau_participant.toString()



//        holder.titles.setOnClickListener {
//            Toast.makeText(context, charItem.alpha, Toast.LENGTH_LONG).show()
//        }

    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var prenom = itemView.findViewById<TextView>(R.id.text_prenom_detail)
        var niveau = itemView.findViewById<TextView>(R.id.text_niveau_detail)

    }
}