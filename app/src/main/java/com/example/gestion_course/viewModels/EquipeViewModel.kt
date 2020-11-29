package com.example.gestion_course.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.gestion_course.entities.Participant

class EquipeViewModel : ViewModel() {

    private lateinit var equipeList: MutableList<String>
    private lateinit var prenomList: MutableList<String>

    private fun initEquipeList() {
        equipeList = mutableListOf(
            "Les Belfortains",
            "Les chanceux",
            "Team Voyou",
            "Team Fromage",
            "Les Supers",
            "BDS UTBM",
            "Les Guerriers",
            "Club DJT",
            "Team Meat",
            "Les Foufous"
        )
        equipeList.shuffle()
    }

    private fun initPrenomList() {
        prenomList = mutableListOf(
            "Sacha",
            "Marco",
            "Serge",
            "Mateao",
            "Vincent",
            "Lucas",
            "Katia",
            "Sabina",
            "Marianne",
            "Constance",
            "Olivia",
            "Appolline",
            "Stevenson",
            "Fabien",
            "Erwan",
            "Kevin",
            "Killian",
            "Hedi",
            "Frederique",
            "Victoire",
            "Salome",
            "Regis",
            "Remi",
            "Anthony",
            "Jordan",
            "Alida",
            "Gwen",
            "Cecilia",
            "Amelie",
            "Ayoub"
        )
        prenomList.shuffle()
    }

    fun createParticipants(nbParticipants: Int){
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }

    //var test: Participant = Participant(null, )

}