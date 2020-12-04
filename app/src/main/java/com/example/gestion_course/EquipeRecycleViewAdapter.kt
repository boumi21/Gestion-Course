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

class EquipeRecycleViewAdapter(var context: Context, var participantList: MutableList<List<Participant>>, var equipe: MutableList<Equipe>) :
        RecyclerView.Adapter<EquipeRecycleViewAdapter.ItemHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val viewHolder = LayoutInflater.from(parent.context)
                .inflate(R.layout.gridview_layout_equipe, parent, false)
        return ItemHolder(viewHolder)
    }

    override fun getItemCount(): Int {
        return participantList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {

        val listPart: List<Participant> = participantList.get(position)

        holder.nomEquipeText.text = equipe.get(position).nom_equipe

        holder.prenomText1.text = listPart[0].nom_participant
        holder.niveauText1.text = listPart[0].niveau_participant.toString()

        holder.prenomText2.text = listPart[1].nom_participant
        holder.niveauText2.text = listPart[1].niveau_participant.toString()

        holder.prenomText3.text = listPart[2].nom_participant
        holder.niveauText3.text = listPart[2].niveau_participant.toString()

        Log.i("le manquant", holder.niveauText1.text.toString())

//        holder.titles.setOnClickListener {
//            Toast.makeText(context, charItem.alpha, Toast.LENGTH_LONG).show()
//        }

    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var nomEquipeText = itemView.findViewById<TextView>(R.id.text_nomEquipe)

        var prenomText1 = itemView.findViewById<TextView>(R.id.text_prenom1_detail)
        var niveauText1 = itemView.findViewById<TextView>(R.id.text_niveau1_detail)

        var prenomText2 = itemView.findViewById<TextView>(R.id.text_prenom2_detail)
        var niveauText2 = itemView.findViewById<TextView>(R.id.text_niveau2_detail)

        var prenomText3 = itemView.findViewById<TextView>(R.id.text_prenom3_detail)
        var niveauText3 = itemView.findViewById<TextView>(R.id.text_niveau3_detail)

    }


}