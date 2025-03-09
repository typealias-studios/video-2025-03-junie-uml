package com.example.daycare.session

import com.example.daycare.Daycare
import com.example.daycare.pets.Pet

class Session(
    private val dayCare: Daycare,
    val schedule: Schedule
) {
    private val attendance: MutableSet<Pet> = mutableSetOf()

    fun onArrived(pet: Pet) {
        require(pet in dayCare) { "Pet must be registered in daycare" }
        attendance.add(pet)
    }

    fun onDeparted(pet: Pet) {
        attendance.remove(pet)
    }
}
