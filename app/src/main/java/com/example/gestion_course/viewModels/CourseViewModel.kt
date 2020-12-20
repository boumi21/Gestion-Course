package com.example.gestion_course.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.gestion_course.AppDatabase
import com.example.gestion_course.entities.Equipe
import com.example.gestion_course.entities.EquipeAvecParticipants
import com.example.gestion_course.entities.Participant
import kotlinx.coroutines.runBlocking

class CourseViewModel(application: Application) : AndroidViewModel(application) {

    val database = AppDatabase.getInstance(application.applicationContext)

    suspend fun getEquipes(): List<Equipe>{
            return database.equipeDao().getAll()
    }

    suspend fun getParticipants(): List<Participant>{

        return database.participantDao().getParticipantsParEquipe()
    }
}