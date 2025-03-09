package com.example.daycare

import com.example.daycare.pets.Pet

class Daycare {
    private val roster: MutableSet<Pet> = mutableSetOf()

    fun register(pet: Pet) {
        roster.add(pet)
    }

    fun unregister(pet: Pet) {
        roster.remove(pet)
    }

    operator fun contains(pet: Pet): Boolean {
        return roster.contains(pet)
    }
}
