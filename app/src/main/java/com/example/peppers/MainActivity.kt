package com.example.peppers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    // TEXTVIEW
    private lateinit var txvInfo: TextView
    private lateinit var classmateList : Array<Classmate>
    private var indexList: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txvInfo = findViewById(R.id.txvInfo)
        this.classmateList = arrayOf<Classmate>()

    }

    fun makeSound(view: View) {
        var number_random = (0..2).random()
        when(number_random) {
            0 -> toast("${classmateList[indexList!!].first_name} esta dormido en clase")
            1 -> toast("${classmateList[indexList!!].first_name} esta jugando Leage of Legend")
            2 -> toast("${classmateList[indexList!!].first_name} ya reprobo por faltas")
        }
    }

    fun play(view: View) {
        var number_random = (0..2).random()
        when(number_random) {
            0 -> toast("${classmateList[indexList!!].first_name} tiene una duda acerca de la herencia en kotlin")
            1 -> toast("${classmateList[indexList!!].first_name} no asistio a clase hoy")
            2 -> toast("${classmateList[indexList!!].first_name} no le gusta la materia")
        }
    }

    fun eat(view: View) {
        var number_random = (0..2).random()
        when(number_random) {
            0 -> toast("${classmateList[indexList!!].first_name} esta comiendo un woke")
            1 -> toast("${classmateList[indexList!!].first_name} esta comiendo ensalada")
            2 -> toast("${classmateList[indexList!!].first_name} no esta comiendo nada")
        }
    }

    fun getPreviousPet(view: View) {
        if ( indexList == 0 ) {
            if ( classmateList.size != 1 ) {
                indexList = classmateList.size-1
            }
        } else {
            indexList = indexList!!-1
        }
        txvInfo.text = "title: ${classmateList[indexList!!].title}\nnombre: ${classmateList[indexList!!].first_name}\napellido: ${classmateList[indexList!!].last_name}\ncarrera: ${classmateList[indexList!!].career}\nedad: ${classmateList[indexList!!].age}\ndescripcion: ${classmateList[indexList!!].description}"

    }

    fun createNewPet(view: View) {
        var random_number = (0..150).random()
        var classmate: Classmate
        when(random_number) {
            in 0..10 -> classmate = Classmate("Jeremy Uriel", "Franco Nunez", null, random_number, "Jugador de LOL", null)
            in 11..50 -> classmate = Classmate("Antonio", "Perez Medina", "ISSC", random_number, "Alumno Regular", "Alumno")
            in 111..120 -> classmate = Classmate("Arturo", "Vallejo Gonzalez", "ISSC", random_number, "Alumno bien portado", "Alumno")
            in 51..100 -> classmate = Classmate("Manuel", "Miranda", "ISSC", random_number,"Trabaja en IBM", "Profesor")
            in 101..110 -> classmate = Classmate("Jazael", "Rivas MAnzano", null, random_number,"Challenger", "Profesor")
            else -> classmate = Classmate("Christian Axel", "Serrano", null, random_number, "Profesor de ISSC", "Profesor")
        }

        var newArray = arrayOf<Classmate>(*classmateList, classmate)
        this.classmateList = newArray
        if ( indexList == null ) {
            indexList = 0
        } else {
            indexList = indexList!! +1
        }

        toast("El nuevo alumno se llama: ${classmate.first_name} ${classmate.last_name}")
        txvInfo.text = "title: ${classmate.title}\nnombre: ${classmate.first_name}\napellido: ${classmate.last_name}\ncarrera: ${classmate.career}\nedad: ${classmate.age}\ndescripcion: ${classmate.description}"
    }

    fun getNextPet(view: View) {
        if ( indexList == (classmateList.size-1) ) {
            indexList = 0
        } else {
            indexList = indexList!! +1
        }
        txvInfo.text = "title: ${classmateList[indexList!!].title}\nnombre: ${classmateList[indexList!!].first_name}\napellido: ${classmateList[indexList!!].last_name}\ncarrera: ${classmateList[indexList!!].career}\nedad: ${classmateList[indexList!!].age}\ndescripcion: ${classmateList[indexList!!].description}"

    }

    private fun toast(message: String) {
        Toast.makeText(this, message + indexList, Toast.LENGTH_LONG).show()
    }
}