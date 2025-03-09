package com.example.daycare.pets

import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import org.junit.jupiter.api.Assertions.assertEquals

class DogTest {
    @Test
    fun `play prints correct sound for each breed`() {
        // Capture console output
        val outputStream = ByteArrayOutputStream()
        val originalOut = System.out
        System.setOut(PrintStream(outputStream))

        try {
            // Test Miniature Schnauzer
            Dog("Max", DogBreed.MINIATURE_SCHNAUZER).play()
            assertEquals("roo-roo\n", outputStream.toString())
            outputStream.reset()

            // Test German Shepherd
            Dog("Rex", DogBreed.GERMAN_SHEPHERD).play()
            assertEquals("ruff!\n", outputStream.toString())
            outputStream.reset()

            // Test Golden Doodle
            Dog("Buddy", DogBreed.GOLDEN_DOODLE).play()
            assertEquals("woof!\n", outputStream.toString())
        } finally {
            // Restore original System.out
            System.setOut(originalOut)
        }
    }
}
