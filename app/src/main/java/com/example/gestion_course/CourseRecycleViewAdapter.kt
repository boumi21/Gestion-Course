package com.example.gestion_course

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gestion_course.entities.Equipe
import com.example.gestion_course.entities.EquipeAvecParticipants
import com.example.gestion_course.entities.Participant

class CourseRecycleViewAdapter(var context: Context, var listEquipes: List<Equipe>, var listParticipants: List<Participant>) :
    RecyclerView.Adapter<CourseRecycleViewAdapter.ItemHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemHolder {
        val viewHolder = LayoutInflater.from(parent.context)
            .inflate(R.layout.gridview_layout_course, parent, false)
        return ItemHolder(viewHolder)
    }

    override fun getItemCount(): Int {
        return listEquipes.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val equipe: Equipe = listEquipes[position]

        holder.nomEquipe.text = equipe.nom_equipe
        //holder.nomParticipant.text = equipeAvecParticipants.participants[0].nom_participant

        Log.i("comment ça", listParticipants.toString())
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var nomEquipe = itemView.findViewById<TextView>(R.id.text_equipe_activity_course)
        var nomParticipant = itemView.findViewById<TextView>(R.id.text_participant_activity_course)

    }


}