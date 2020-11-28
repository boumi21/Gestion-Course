package com.example.gestion_course.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Equipe (
    @PrimaryKey val num_equipe: Int,
    val nom_equipe: String,
)