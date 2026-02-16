package org.studentmanagement.service;

import org.junit.jupiter.api.Test;
import org.studentmanagement.models.Student;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    void addMarks() {
        Student student = new Student("Aditya");
        StudentService service = new StudentService();

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> service.addMarks(student, -10)
        );

        assertEquals("Marks must be 0-100", ex.getMessage());
    }

}