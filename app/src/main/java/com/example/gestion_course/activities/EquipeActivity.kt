package com.example.gestion_course.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gestion_course.R
import kotlinx.android.synthetic.main.activity_equipe.*

class EquipeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_equipe)

        val nbParticipants = intent.getIntExtra("nbParticipants", 9)

        text_test.text = nbParticipants.toString()
    }
}