package com.example.gestion_course.dao

import androidx.room.*
import com.example.gestion_course.entities.Equipe
import com.example.gestion_course.entities.EquipeAvecParticipants

@Dao
interface EquipeDao {
//    @Query("SELECT * FROM equipe")
//    fun getAll(): List<Equipe>

    @Transaction
    @Query("SELECT * FROM equipe")
    fun getEquipeAvecParticipants(): List<EquipeAvecParticipants>


//    @Query("SELECT * FROM equipe WHERE num_equipe IN (:numEquipe)")
//    fun loadAllByIds(numEquipe: IntArray): List<Equipe>

    @Insert
    fun insertAll(vararg equipes: Equipe)

    @Delete
    fun delete(equipe: Equipe)

}