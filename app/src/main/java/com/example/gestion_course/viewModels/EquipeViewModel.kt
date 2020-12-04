package com.example.gestion_course.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.gestion_course.entities.Equipe
import com.example.gestion_course.entities.EquipeAvecParticipants
import com.example.gestion_course.entities.Participant
import kotlin.random.Random

class EquipeViewModel : ViewModel() {

    private lateinit var nomEquipeList: MutableList<String>
    private lateinit var prenomList: MutableList<String>
    private var totalNiveau: Int = 0
    private var moyenneNiveauEquipe: Int = 0
    private var moyenneNiveauParticipant: Int = 0
    private var nbTotalParticipants: Int = 0
    private var nbEquipes: Int = 0
    private var participantList = mutableListOf<Participant>()
    private var equipeList = mutableListOf<Equipe>()
    private var listParticipantList = mutableListOf<List<Participant>>()

    private fun initEquipeList() {
        nomEquipeList = mutableListOf(
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
        nomEquipeList.shuffle()
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

    fun genereEquipes(nbParticipants: Int, prenomParticipantManuel: String, niveauParticipantManuel: Int){
        nbTotalParticipants = nbParticipants
        nbEquipes = nbParticipants/3
        createEquipes(nbParticipants)
        createParticipants(nbParticipants, prenomParticipantManuel, niveauParticipantManuel)
        getTotalNiveau()
        getMoyenneNiveauEquipe()
        getMoyenneNiveauParticipant()
        sortParticipantParNiveau()


        for (i in 1..nbEquipes){
            fillEquipe()
        }
        Log.i("complet", listParticipantList.toString())
    }

    private fun createEquipes(nbParticipants: Int){
        initEquipeList()

        for (i in 1..nbEquipes){
            var equipe: Equipe = Equipe(i, nomEquipeList[i-1])
            equipeList.add(equipe)
        }
    }

    fun createParticipants(nbParticipants: Int, prenomParticipantManuel: String, niveauParticipantManuel: Int){
        initPrenomList()
        val nbParticipantsGenere = nbParticipants - 1

        for (i in 1..nbParticipantsGenere){
            var part = Participant(i, prenomList[i-1], Random.nextInt(1, 100), null, null)
            participantList.add(part)
        }

        //On ajoute le participant rentré manuellement
        var part = Participant(nbParticipants, prenomParticipantManuel, niveauParticipantManuel, null, null)
        participantList.add(part)
    }

    fun getTotalNiveau(){
        var listNiveau: List<Int> = participantList.map { it.niveau_participant }
        totalNiveau = listNiveau.sum()
    }

    fun getMoyenneNiveauEquipe(){
        moyenneNiveauEquipe = totalNiveau/nbEquipes
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
        equipe.add(participantList.removeLast())

        while (equipe.size < 3){
            var listNiveauEquipe: List<Int> = equipe.map { it.niveau_participant }
            if (equipeFort(listNiveauEquipe.sum())){
                equipe.add(participantList.removeFirst())
            } else {
                equipe.add(participantList.removeLast())
            }
        }
        listParticipantList.add(equipe)

        var listNiveauTest: List<Int> = equipe.map { it.niveau_participant }
        Log.i("Niveau equipe", listNiveauTest.sum().toString())
    }

    private fun equipeFort(niveauTotalEquipe: Int): Boolean{
        return niveauTotalEquipe > moyenneNiveauEquipe
    }

    fun getEquipes(): MutableList<List<Participant>>{
        return listParticipantList
    }

    fun getNomEquipes(): MutableList<Equipe>{
        return equipeList
    }

    //var test: EquipeAvecParticipants = EquipeAvecParticipants()


}