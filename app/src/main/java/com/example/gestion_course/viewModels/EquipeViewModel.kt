package com.example.gestion_course.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.gestion_course.entities.Equipe
import com.example.gestion_course.entities.EquipeAvecParticipants
import com.example.gestion_course.entities.Participant
import kotlin.random.Random

class EquipeViewModel : ViewModel() {

    private lateinit var equipeList: MutableList<String>
    private lateinit var prenomList: MutableList<String>
    private var totalNiveau: Int = 0
    private var moyenneNiveauEquipe: Int = 0
    private var moyenneNiveauParticipant: Int = 0
    private var nbTotalParticipants: Int = 0
    private var participantList = mutableListOf<Participant>()
    private var listParticipantList = mutableListOf<List<Participant>>()

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

    private fun createEquipes(nbParticipants: Int){
        initEquipeList()
        for (i in 1..nbParticipants){
            var equipe: Equipe = Equipe(i, equipeList[i-1])
        }
    }

    fun createParticipants(nbParticipants: Int){
        initPrenomList()
        nbTotalParticipants = nbParticipants

        for (i in 1..nbParticipants){
            var part: Participant = Participant(i, prenomList[i-1], Random.nextInt(1, 100), null, null)
            participantList.add(part)
        }
    }

    fun getTotalNiveau(){
        var listNiveau: List<Int> = participantList.map { it.niveau_participant }
        totalNiveau = listNiveau.sum()
    }

    fun getMoyenneNiveauEquipe(){
        moyenneNiveauEquipe = totalNiveau/(nbTotalParticipants/3)
    }

    fun getMoyenneNiveauParticipant(){
        moyenneNiveauParticipant = totalNiveau/nbTotalParticipants
    }

    fun sortParticipantParNiveau(){
        participantList.sortBy { it.niveau_participant }
    }

    // Faire cette fonction là autant de fois que le nombre d'équipes
    fun fillEquipe(){
        var equipe = mutableListOf<Participant>()
        equipe.add(participantList.last())

        while (equipe.size < 3){
            var listNiveauEquipe: List<Int> = equipe.map { it.niveau_participant }
            if (equipeFort(listNiveauEquipe.sum())){
                equipe.add(participantList.first())
            } else {
                equipe.add(participantList.last())
            }
        }
        listParticipantList.add(equipe)
    }

    private fun equipeFort(niveauTotalEquipe: Int): Boolean{
        return niveauTotalEquipe > moyenneNiveauEquipe
    }

    //var test: EquipeAvecParticipants = EquipeAvecParticipants()


}