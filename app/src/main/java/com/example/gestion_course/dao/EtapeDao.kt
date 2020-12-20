package com.example.gestion_course.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.gestion_course.entities.Equipe
import com.example.gestion_course.entities.Etape

@Dao
interface EtapeDao {

    @Query("SELECT * FROM etape")
    fun getAll(): List<Etape>
}