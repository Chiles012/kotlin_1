package com.example.peppers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    // TEXTVIEW
    private lateinit var txvInfo: TextView
    private lateinit var peopleList : Array<People>
    private var indexList: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txvInfo = findViewById(R.id.txvInfo)
        this.peopleList = arrayOf<People>()

    }

    fun makeSound(view: View) {
        toast(peopleList[indexList!!].getInfo())
    }

    fun play(view: View) {
        toast(peopleList[indexList!!].play())
    }

    fun eat(view: View) {
        toast(peopleList[indexList!!].eat())
    }

    fun getPreviousPet(view: View) {
        if ( indexList == 0 ) {
            if ( peopleList.size != 1 ) {
                indexList = peopleList.size-1
            }
        } else {
            indexList = indexList!!-1
        }
        chageText()

    }

    fun chageText() {
        txvInfo.text = peopleList[indexList!!].getInfo()
    }

    fun createNewPet(view: View) {
        var random_number = (0..150).random()
        var people: People
        when(random_number) {
            in 0..10 -> people = Teacher("Jeremy Uriel", "Franco Nunez", 19,"Profesor de la universidad de la salle bajio en la facultd de derecho")
            in 11..50 -> people = Teacher("Antonio", "Perez Medina", 22, "Experto en React js y aplicaciones webs")
            in 111..120 -> people = Teacher("Arturo", "Vallejo Gonzalez", 20,"Profesor experto en ciencia de datos")
            in 51..100 -> people = Classmate("Manuel", "Miranda", 24, "Aficionado con LOL")
            in 101..110 -> people = Classmate("Jazael", "Rivas MAnzano", 22, "Challenger")
            else -> people = Classmate("Christian Axel", "Serrano", 20, "Jefe de grupo del 511")
        }

        var newArray = arrayOf<People>(*peopleList, people)
        this.peopleList = newArray
        if ( indexList == null ) {
            indexList = 0
        } else {
            indexList = indexList!! +1
        }

        toast(peopleList[indexList!!].getInfo())
        chageText()
    }

    fun getNextPet(view: View) {
        if ( indexList == (peopleList.size-1) ) {
            indexList = 0
        } else {
            indexList = indexList!! +1
        }
        chageText()
    }

    private fun toast(message: String) {
        Toast.makeText(this, message + indexList, Toast.LENGTH_LONG).show()
    }
}