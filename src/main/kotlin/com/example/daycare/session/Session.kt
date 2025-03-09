package com.example.daycare.session

import com.example.daycare.Activity
import com.example.daycare.Daycare
import com.example.daycare.exceptions.NotRegisteredException
import com.example.daycare.pets.Pet

class Session(
    private val dayCare: Daycare,
    val schedule: Schedule
) {
    private val attendance: MutableSet<Pet> = mutableSetOf()

    fun onArrived(pet: Pet) {
        if (pet !in dayCare) {
            throw NotRegisteredException("Pet must be registered in daycare")
        }
        attendance.add(pet)
    }

    fun onDeparted(pet: Pet) {
        attendance.remove(pet)
    }

    fun runSchedule() {
        for (activity in schedule) {
            for (pet in attendance) {
                println("${pet.name} is ${activity.verb}")
                if (activity == Activity.PLAY) {
                    pet.play()
                }
            }
        }
    }
}
