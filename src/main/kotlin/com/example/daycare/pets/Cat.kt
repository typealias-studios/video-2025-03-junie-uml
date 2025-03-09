package com.example.daycare.pets

class Cat(
    override val name: String
) : Pet {
    override fun play() {
        println("Meow!")
    }
}
