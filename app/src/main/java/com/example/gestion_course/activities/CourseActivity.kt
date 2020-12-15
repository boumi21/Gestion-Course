package com.example.gestion_course.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gestion_course.CourseRecycleViewAdapter
import com.example.gestion_course.EquipeRecycleViewAdapter
import com.example.gestion_course.R
import com.example.gestion_course.entities.EquipeAvecParticipants
import com.example.gestion_course.viewModels.CourseViewModel
import com.example.gestion_course.viewModels.EquipeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class CourseActivity : AppCompatActivity() {

    private lateinit var courseViewModel: CourseViewModel
    private lateinit var courseRecyclerView: RecyclerView
    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var courseAdapter: CourseRecycleViewAdapter
    private lateinit var equipesAvecParticipants: List<EquipeAvecParticipants>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)

        // Get the viewModel
        courseViewModel = ViewModelProvider(this).get(CourseViewModel::class.java)


        runBlocking {
            withContext(Dispatchers.IO) {
                equipesAvecParticipants = courseViewModel.getEquipesAvecParticipants()
            }
        }






        createRecyclerView()
    }

    private fun createRecyclerView(){
        courseRecyclerView = findViewById(R.id.recyclerview_course)
        gridLayoutManager = GridLayoutManager(applicationContext, 3, LinearLayoutManager.VERTICAL, false)
        courseRecyclerView.layoutManager = gridLayoutManager
        courseRecyclerView.setHasFixedSize(true)
        courseAdapter = CourseRecycleViewAdapter(applicationContext, equipesAvecParticipants)
        courseRecyclerView.adapter = courseAdapter
    }
}