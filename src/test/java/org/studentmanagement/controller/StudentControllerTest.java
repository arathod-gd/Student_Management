package org.studentmanagement.controller;

import org.junit.jupiter.api.*;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class StudentControllerTest {

    private StudentController controller;
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        controller = new StudentController();

        // Capture System.out
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void createStudent() {

    }

    @Test
    void addMarks() {
        // First create student
        controller.createStudent(new Scanner("Rahul\n"));

        // Add marks
        String input = "Rahul\n3\n80\n90\n70\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));

        controller.addMarks(sc);

        String output = outContent.toString();
        assertTrue(output.contains("Marks updated"));
    }

    @Test
    void removeStudent() {
        controller.createStudent(new Scanner("Aman\n"));

        controller.removeStudent(new Scanner("Aman\n"));

        String output = outContent.toString();
        assertTrue(output.contains("Student removed"));
    }

    @Test
    void searchStudent() {
        controller.createStudent(new Scanner("Neha\n"));

        controller.searchStudent(new Scanner("Neha\n"));

        String output = outContent.toString();
        assertTrue(output.contains("Neha"));
    }

    @Test
    void displayFromFile() {
        // Just verify it doesn't crash
        assertDoesNotThrow(() -> controller.displayFromFile());
    }
}
