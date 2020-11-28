package com.example.gestion_course.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Participant (
    @PrimaryKey val num_participant: Int,
    val nom_participant: String,
    val niveau_participant: Int,
    val ordre_passage: Int,
    val num_equipe_participant: Int
)