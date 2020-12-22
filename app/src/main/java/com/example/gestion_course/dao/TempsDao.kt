package com.example.gestion_course.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.gestion_course.entities.Etape
import com.example.gestion_course.entities.Temps

@Dao
interface TempsDao {
    @Insert
    fun insertTemps(temps: Temps)
}