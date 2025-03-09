package com.example.daycare.session

import com.example.daycare.Activity
import com.example.daycare.Daycare
import com.example.daycare.exceptions.NotRegisteredException
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
        assertThrows<NotRegisteredException> {
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

    private class TestPet(override val name: String = "Test Pet") : Pet {
        var playWasCalled = false
        override fun play() {
            playWasCalled = true
        }
    }

    @Test
    fun `runSchedule prints activities and calls play only for PLAY activity`() {
        val pet1 = TestPet("Fido")
        val pet2 = TestPet("Whiskers")
        val activities = listOf(Activity.PLAY, Activity.NAP, Activity.EAT)
        val sessionWithMultipleActivities = Session(daycare, Schedule(activities))

        daycare.register(pet1)
        daycare.register(pet2)
        sessionWithMultipleActivities.onArrived(pet1)
        sessionWithMultipleActivities.onArrived(pet2)

        sessionWithMultipleActivities.runSchedule()

        assert(pet1.playWasCalled) { "play() should be called for PLAY activity" }
        assert(pet2.playWasCalled) { "play() should be called for PLAY activity" }
    }
}
