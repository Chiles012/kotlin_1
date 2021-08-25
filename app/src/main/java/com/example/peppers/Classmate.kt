package com.example.peppers

abstract class People(
    protected val first_name: String? = "",
    protected val last_name: String? = "",
    private val age: Int? = 0,
    private val description: String = ""
) {
    abstract val title: String

    fun getInfo() =
        "Your people is a: $title \\n its name is: $first_name $last_name \\n its age is $age \\n its description id $description"

    abstract fun makeSound(): String
    abstract fun play(): String
    abstract fun eat(): String
}

class Classmate(first_name: String?, last_name: String?, age: Int?, description: String) : People(first_name, last_name, age, description) {

    override val title = "classmate"

    override fun makeSound() = "El alumno $first_name esta estudiando redes neuronales"

    override fun play() = "El alumno $first_name esta jugando smash"

    override fun eat() = "El alumno $first_name esta comiendo en su hora libre"

}

class Teacher(first_name: String?, last_name: String?, age: Int?, description: String) : People(first_name, last_name, age, description) {

    override val title = "teacher"

    override fun makeSound() = "El profesor $first_name esta ensenando algoritmos de redes neuronales"

    override fun play() = "El profesor $first_name esta jugando smash"

    override fun eat() = "El profesor $first_name esta comiendo en su hora libre"

}
