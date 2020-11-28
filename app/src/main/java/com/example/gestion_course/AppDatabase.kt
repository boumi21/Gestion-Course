package com.example.gestion_course

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gestion_course.dao.EquipeDao
import com.example.gestion_course.dao.ParticipantDao
import com.example.gestion_course.entities.Equipe
import com.example.gestion_course.entities.Participant

@Database(entities = arrayOf(Equipe::class, Participant::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun equipeDao(): EquipeDao
    abstract fun participantDao(): ParticipantDao

    companion object {
        private var instance: AppDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context): AppDatabase {
            if (instance == null)
                instance = Room.databaseBuilder(
                    ctx.applicationContext, AppDatabase::class.java,
                    "app_database"
                )
                    .fallbackToDestructiveMigration()
                    //.addCallback(roomCallback)
                    .build()

            return instance!!

        }
    }
}