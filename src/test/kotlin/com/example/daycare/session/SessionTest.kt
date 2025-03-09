package com.example.daycare.session

import com.example.daycare.Activity
import com.example.daycare.Daycare
import com.example.daycare.pets.Pet
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class SessionTest {
    private val daycare = Daycare()
    private val schedule = Schedule(listOf(Activity.PLAY))
    private val session = Session(daycare, schedule)
    private val pet = TestPet()

    @Test
    fun `registered pet can arrive`() {
        daycare.register(pet)
        session.onArrived(pet)
    }

    @Test
    fun `unregistered pet cannot arrive`() {
        assertThrows<IllegalArgumentException> {
            session.onArrived(pet)
        }
    }

    @Test
    fun `pet can depart`() {
        daycare.register(pet)
        session.onArrived(pet)
        session.onDeparted(pet)
    }

    @Test
    fun `can depart pet that is not in attendance`() {
        session.onDeparted(pet) // Should not throw
    }

    private class TestPet : Pet {
        override val name: String = "Test Pet"
        override fun play() {}
    }
}
