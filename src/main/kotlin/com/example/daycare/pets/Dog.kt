package com.example.daycare.pets

class Dog(
    override val name: String,
    private val breed: DogBreed
) : Pet {
    override fun play() {
        val sound = when (breed) {
            DogBreed.MINIATURE_SCHNAUZER -> "roo-roo"
            DogBreed.GERMAN_SHEPHERD -> "ruff!"
            DogBreed.GOLDEN_DOODLE -> "woof!"
        }
        println(sound)
    }
}

enum class DogBreed {
    MINIATURE_SCHNAUZER,
    GERMAN_SHEPHERD,
    GOLDEN_DOODLE
}
