package org.studentmanagement.models;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student student = new Student("Aditya");

    @Test
    void getName() {
        assertEquals("Aditya", student.getName());
    }

    @Test
    void getMarks() {
        assertNotNull(student.getMarks());
        assertTrue(student.getMarks().isEmpty());
    }

    @Test
    void getAggregate() {
        student.setAggregate(85.5);
        assertEquals(85.5, student.getAggregate());
    }

    @Test
    void setAggregate() {
        student.setAggregate(72.0);
        assertEquals(72.0, student.getAggregate());
    }

    @Test
    void getGrade() {
        student.setGrade('A');
        assertEquals('A', student.getGrade());
    }

    @Test
    void setGrade() {
        student.setGrade('B');
        assertEquals('B', student.getGrade());
    }

    @Test
    void toFileString() {
        student.getMarks().addAll(Arrays.asList(80.0, 90.0, 70.0));
        student.setAggregate(80.0);
        student.setGrade('A');

        String expected = "Name: Aditya Marks: [80.0, 90.0, 70.0] Aggregate: 80.0 Grade: A";
        assertEquals(expected, student.toFileString());
    }

    @Test
    void testToString() {
        student.setAggregate(60.0);
        student.setGrade('C');

        // toString() should delegate to toFileString()
        assertEquals(student.toFileString(), student.toString());
    }
}
