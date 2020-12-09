package com.example.gestion_course

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gestion_course.entities.Equipe
import com.example.gestion_course.entities.Participant


class EquipeRecycleViewAdapter(var context: Context, var participantList: MutableList<List<Participant>>, var equipe: MutableList<Equipe>) :
        RecyclerView.Adapter<EquipeRecycleViewAdapter.ItemHolder>() {

    var viewpool : RecyclerView.RecycledViewPool = RecyclerView.RecycledViewPool()


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


        // Create layout manager with initial prefetch item count
        val layoutManager = LinearLayoutManager(
                holder.recycleViewEquipeDetail.context,
                RecyclerView.VERTICAL,
                false
        )

        layoutManager.initialPrefetchItemCount = listPart.size


        // Create sub item view adapter
        val equipeDetailRecycleViewAdapter = EquipeDetailRecycleViewAdapter(listPart)

        holder.recycleViewEquipeDetail.layoutManager = layoutManager
        holder.recycleViewEquipeDetail.adapter = equipeDetailRecycleViewAdapter
        holder.recycleViewEquipeDetail.setRecycledViewPool(viewpool)

//        holder.titles.setOnClickListener {
//            Toast.makeText(context, charItem.alpha, Toast.LENGTH_LONG).show()
//        }

    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var nomEquipeText = itemView.findViewById<TextView>(R.id.text_nomEquipe)
        var recycleViewEquipeDetail = itemView.findViewById<RecyclerView>(R.id.recyclerview_equipe_detail)

    }


}