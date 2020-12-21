package com.example.gestion_course

import android.content.Context
import android.os.SystemClock
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Chronometer
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gestion_course.entities.Equipe
import com.example.gestion_course.entities.EquipeAvecParticipants
import com.example.gestion_course.entities.Etape
import com.example.gestion_course.entities.Participant
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CourseRecycleViewAdapter(var context: Context, var listEquipes: List<Equipe>, var listParticipantsList: List<List<Participant>>, var listEtapes: List<Etape>) :
    RecyclerView.Adapter<CourseRecycleViewAdapter.ItemHolder>() {

    val database = AppDatabase.getInstance(context)
    var numParticipantActif = 1

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
        holder.nomParticipant.text = listParticipantsList[position].find { it.ordre_passage == numParticipantActif }!!.nom_participant
        holder.etapeParticipant.text = listEtapes[listParticipantsList[position].find { it.ordre_passage == numParticipantActif }!!.num_etape_participant!!-1].nom_etape


        holder.itemView.setOnClickListener{
            var participantActif = listParticipantsList[position].find { it.ordre_passage == numParticipantActif }
            var etapeActive = listEtapes[participantActif!!.num_etape_participant!!-1]

            Log.i("voila",etapeActive.toString())

            holder.chrono.base = SystemClock.elapsedRealtime()
            holder.chrono.start()
            if (etapeActive.num_etape == 6){
                holder.etapeParticipant.text = listEtapes[0].nom_etape
                updateEtape(participantActif!!.num_participant, listEtapes[0].num_etape)
            } else if (etapeActive.num_etape == 5){
                updateEtape(participantActif!!.num_participant, listEtapes[5].num_etape)
                numParticipantActif++
                holder.nomParticipant.text = listParticipantsList[position].find { it.ordre_passage == numParticipantActif }!!.nom_participant
                holder.etapeParticipant.text = listEtapes[0].nom_etape
                updateEtape(participantActif!!.num_participant, listEtapes[0].num_etape)
            } else {
                Log.i("test","je passe ici")
                updateEtape(participantActif!!.num_participant, etapeActive.num_etape+1)
                holder.etapeParticipant.text = listEtapes[etapeActive.num_etape].nom_etape
                updateEtape(participantActif!!.num_participant, etapeActive.num_etape)
            }
        }

    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var nomEquipe = itemView.findViewById<TextView>(R.id.text_equipe_activity_course)
        var nomParticipant = itemView.findViewById<TextView>(R.id.text_participant_activity_course)
        var etapeParticipant = itemView.findViewById<TextView>(R.id.text_etape_activity_course)
        var chrono = itemView.findViewById<Chronometer>(R.id.chrono_time)

    }

    private fun updateEtape(id: Int, numEtape: Int){
        // On met à jour la bdd
        GlobalScope.launch {
            database.participantDao().updateParticipant(id, numEtape)
        }
    }


}