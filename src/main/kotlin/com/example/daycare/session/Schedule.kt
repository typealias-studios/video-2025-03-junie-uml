package com.example.daycare.session

import com.example.daycare.Activity

class Schedule(private val steps: List<Activity>) : Iterable<Activity> {
    override fun iterator(): Iterator<Activity> = steps.iterator()
}
