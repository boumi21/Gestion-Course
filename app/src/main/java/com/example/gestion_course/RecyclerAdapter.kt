package com.example.gestion_course

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gestion_course.entities.Participant

class RecyclerAdapter(private val participantList: ArrayList<Participant>) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
//        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_list_layout, parent, false)
//        return MyViewHolder(v)
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_list_layout, parent, false)
        return MyViewHolder(v, parent)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val participant = participantList[position]
        holder.bind(participant)
    }
    override fun getItemCount(): Int {
        return participantList.size
    }
    class MyViewHolder(itemView: View, parent: ViewGroup) : RecyclerView.ViewHolder(itemView) {

        private var prenomView: TextView? = null
        private var niveauView: TextView? = null

        init {
            prenomView = itemView.findViewById(R.id.part_prenom)
            niveauView = itemView.findViewById(R.id.part_niveau)
        }

        fun bind(part: Participant) {
            prenomView?.text = part.nom_participant
            niveauView?.text = part.niveau_participant.toString()
        }

    }
}