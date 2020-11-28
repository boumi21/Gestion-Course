package com.example.gestion_course.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.gestion_course.entities.Participant

@Dao
interface ParticipantDao {
    @Query("SELECT * FROM participant")
    fun getAll(): List<Participant>

    @Query("SELECT * FROM participant WHERE num_participant IN (:numParticipant)")
    fun loadAllByIds(numParticipant: IntArray): List<Participant>

    @Insert
    fun insertAll(vararg participants: Participant)

    @Delete
    fun delete(participant: Participant)
}