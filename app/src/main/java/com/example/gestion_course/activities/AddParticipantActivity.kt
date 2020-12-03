package com.example.gestion_course.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import com.example.gestion_course.R
import kotlinx.android.synthetic.main.activity_add_participant.*
import kotlinx.android.synthetic.main.activity_main.*

class AddParticipantActivity : AppCompatActivity() {

    var niveauPart: Int = 9

    fun goNextPage(nbParticipants: Int, prenom: String){
        val intent = Intent(this, EquipeActivity::class.java)
        intent.putExtra("nbParticipants",nbParticipants)
        intent.putExtra("prenomParticipant",prenom)
        intent.putExtra("niveauParticipant",niveauPart)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_participant)

        val nbParticipants = intent.getIntExtra("nbParticipants", 9)



        button_valid.setOnClickListener {
            if(editText_prenom.text.isNotEmpty()){
                goNextPage(nbParticipants, editText_prenom.text.toString())
            } else {
                //afficher message
            }
                editText_prenom.text.isNotEmpty().apply {
            }

        }





        // Set a SeekBar change listener
        seekBar_niveau.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // Met à jour le niveau quand la valeur de la seekbar change
                var niveau: Int = progress + 1
                niveauPart = niveau
                text_niveau.text = "Niveau : $niveau"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Do something
                //Toast.makeText(applicationContext,"start tracking",Toast.LENGTH_SHORT).show()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Do something
                //Toast.makeText(applicationContext,"stop tracking",Toast.LENGTH_SHORT).show()
            }
        })
    }
}