package com.example.gestion_course.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.gestion_course.R
import com.example.gestion_course.viewModels.EquipeViewModel
import kotlinx.android.synthetic.main.activity_equipe.*

class EquipeActivity : AppCompatActivity() {

    private lateinit var equipeViewModel: EquipeViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_equipe)
        // Get the viewModel
        equipeViewModel = ViewModelProvider(this).get(EquipeViewModel::class.java)

        val nbParticipants = intent.getIntExtra("nbParticipants", 9)
        val niveauParticipantManuel = intent.getIntExtra("niveauParticipant", 1)
        val prenomParticipanManuel = intent.getStringExtra("prenomParticipant")


        equipeViewModel.genereEquipes(nbParticipants, prenomParticipanManuel, niveauParticipantManuel)
    }
}