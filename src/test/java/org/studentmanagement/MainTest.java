package org.studentmanagement;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private PrintStream originalOut;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        originalOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void showMenu() {
        Main.showMenu();

        String output = outContent.toString();

        assertTrue(output.contains("Student Management System")
                || output.contains("Create Student"));
    }

    @Test
    void main_exitImmediately() {
        // Simulate user entering 6 (Exit)
        String input = "6\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertDoesNotThrow(() -> Main.main(new String[]{}));
    }
}
