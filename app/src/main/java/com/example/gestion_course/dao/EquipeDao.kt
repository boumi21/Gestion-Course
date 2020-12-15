package com.example.gestion_course.dao

import androidx.room.*
import com.example.gestion_course.entities.Equipe
import com.example.gestion_course.entities.EquipeAvecParticipants
import com.example.gestion_course.entities.Participant

@Dao
interface EquipeDao {
    @Query("SELECT * FROM equipe")
    fun getAll(): List<Equipe>

    @Transaction
    @Query("SELECT * FROM Equipe")
    fun getEquipeAvecParticipants(): List<EquipeAvecParticipants>


//    @Query("SELECT * FROM equipe WHERE num_equipe IN (:numEquipe)")
//    fun loadAllByIds(numEquipe: IntArray): List<Equipe>

    @Insert
    suspend fun insertAll(vararg equipes: Equipe)

    @Insert
    suspend fun insertEquipeAvecParticipants(equipe: Equipe, participants: List<Participant>)

    @Insert
    fun insertParticipants(participants: List<Participant>)

    @Delete
    fun delete(equipe: Equipe)

}