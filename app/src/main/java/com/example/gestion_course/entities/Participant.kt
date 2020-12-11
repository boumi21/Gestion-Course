package com.example.gestion_course.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Participant (
    @PrimaryKey(autoGenerate = false) val num_participant: Int,
    val nom_participant: String,
    val niveau_participant: Int,
    val ordre_passage: Int?,
    var num_equipe_participant: Int?
)