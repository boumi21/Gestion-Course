package com.example.gestion_course.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.gestion_course.AppDatabase
import com.example.gestion_course.entities.EquipeAvecParticipants
import kotlinx.coroutines.runBlocking

class CourseViewModel(application: Application) : AndroidViewModel(application) {

    val database = AppDatabase.getInstance(application.applicationContext)

    suspend fun getEquipesAvecParticipants(): List<EquipeAvecParticipants>{
            return database.equipeDao().getEquipeAvecParticipants()
    }
}