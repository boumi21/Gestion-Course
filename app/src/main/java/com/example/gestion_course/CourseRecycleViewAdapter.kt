package com.example.gestion_course

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gestion_course.entities.Equipe
import com.example.gestion_course.entities.Participant

class CourseRecycleViewAdapter(var context: Context, var equipeList: List<Equipe>, var listParticipantList: MutableList<List<Participant>>) :
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
        return listParticipantList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        TODO("Not yet implemented")
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //var nomEquipeText = itemView.findViewById<TextView>(R.id.text_nomEquipe)
        //var recycleViewEquipeDetail = itemView.findViewById<RecyclerView>(R.id.recyclerview_equipe_detail)

    }


}