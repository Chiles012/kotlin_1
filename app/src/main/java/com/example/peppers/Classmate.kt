package com.example.peppers

open class Classmate {
    var first_name: String?
    var last_name: String?
    var career: String?
    var age: Int? = 0
    var description: String
    var title: String?

    constructor(first_name: String?, last_name: String?, career: String?, age: Int?, description: String, title: String?) {
        this.first_name = first_name
        this.last_name = last_name
        this.career = career
        this.age = age
        this.description = description
        this.title = title
    }
}