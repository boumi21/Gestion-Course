package com.example.gestion_course.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gestion_course.CourseRecycleViewAdapter
import com.example.gestion_course.EquipeRecycleViewAdapter
import com.example.gestion_course.R
import com.example.gestion_course.entities.Equipe
import com.example.gestion_course.entities.EquipeAvecParticipants
import com.example.gestion_course.entities.Etape
import com.example.gestion_course.entities.Participant
import com.example.gestion_course.viewModels.CourseViewModel
import com.example.gestion_course.viewModels.EquipeViewModel
import kotlinx.android.synthetic.main.activity_course.*
import kotlinx.android.synthetic.main.activity_equipe.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class CourseActivity : AppCompatActivity() {

    private lateinit var courseViewModel: CourseViewModel
    private lateinit var courseRecyclerView: RecyclerView
    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var courseAdapter: CourseRecycleViewAdapter
    private lateinit var listEquipes: List<Equipe>
    private lateinit var listEtapes: List<Etape>
    private lateinit var listParticipantsList: List<List<Participant>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)

        listenStart()

        // Get the viewModel
        courseViewModel = ViewModelProvider(this).get(CourseViewModel::class.java)


        runBlocking {
            withContext(Dispatchers.IO) {
                listEquipes = courseViewModel.getEquipes()
                listEtapes = courseViewModel.getEtapes()
                listParticipantsList = courseViewModel.getParticipants(listEquipes.size)
            }
        }






        createRecyclerView()
    }

    private fun createRecyclerView(){
        courseRecyclerView = findViewById(R.id.recyclerview_course)
        gridLayoutManager = GridLayoutManager(applicationContext, 3, LinearLayoutManager.VERTICAL, false)
        courseRecyclerView.layoutManager = gridLayoutManager
        courseRecyclerView.setHasFixedSize(true)
        courseAdapter = CourseRecycleViewAdapter(applicationContext, listEquipes, listParticipantsList, listEtapes)
        courseRecyclerView.adapter = courseAdapter
    }

    private fun listenStart(){
        button_start_stat.setOnClickListener {
            val intent = Intent(this, StatActivity::class.java)
            startActivity(intent)
        }
    }
}