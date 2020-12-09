package com.example.gestion_course.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gestion_course.EquipeRecycleViewAdapter
import com.example.gestion_course.R
import com.example.gestion_course.entities.Equipe
import com.example.gestion_course.entities.Participant
import com.example.gestion_course.viewModels.EquipeViewModel


class EquipeActivity : AppCompatActivity() {

    private lateinit var equipeViewModel: EquipeViewModel
    private var recyclerView: RecyclerView? = null
    private var gridLayoutManager: GridLayoutManager? = null
    private var equipeAdapter: EquipeRecycleViewAdapter? = null
    private var listEquipeParticipant= mutableListOf<List<Participant>>()
    private var listEquipe = mutableListOf<Equipe>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_equipe)


        // Get the viewModel
        equipeViewModel = ViewModelProvider(this).get(EquipeViewModel::class.java)

        val nbParticipants = intent.getIntExtra("nbParticipants", 9)
        val niveauParticipantManuel = intent.getIntExtra("niveauParticipant", 1)
        val prenomParticipanManuel = intent.getStringExtra("prenomParticipant")


        equipeViewModel.genereEquipes(nbParticipants, prenomParticipanManuel, niveauParticipantManuel)

        var listParticipantList = equipeViewModel.getEquipes()
        for (i in 1..listParticipantList.size){
            listEquipeParticipant.add(listParticipantList[i - 1])
        }

        listEquipe = equipeViewModel.getNomEquipes()

        createRecyclerView()




//        for (i in 1..listParticipantList.size){
//            val cardView = CardView(this)
//            cardView.radius = 15f
//            cardView.setCardBackgroundColor(Color.parseColor("#009688"))
//            cardView.setContentPadding(36,36,36,36)
//            //cardView.layoutParams = params
//            cardView.cardElevation = 30f
//
//            val textPrenom1 = TextView(this)
//            val textPrenom2 = TextView(this)
//            val textPrenom3 = TextView(this)
//            textPrenom1.text = listParticipantList[i-1][0].nom_participant
//            textPrenom2.text = listParticipantList[i-1][1].nom_participant
//            textPrenom3.text = listParticipantList[i-1][2].nom_participant
//
////            val textTest = TextView(this)
////            textTest.text = "bobo le clown"
//            cardView.addView(textPrenom1)
//            cardView.addView(textPrenom2)
//            cardView.addView(textPrenom3)
//            grid_equipes.addView(cardView)
//        }
    }

    fun createRecyclerView(){
        recyclerView = findViewById(R.id.recyclerview_equipe)
        gridLayoutManager = GridLayoutManager(applicationContext, 3, LinearLayoutManager.VERTICAL, false)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        equipeAdapter = EquipeRecycleViewAdapter(applicationContext, listEquipeParticipant!!, listEquipe)
        recyclerView?.adapter = equipeAdapter
    }
}