package org.studentmanagement.service;

import org.studentmanagement.models.Student;

public class StudentService {

    public void addMarks(Student student, double mark) {
        if (mark < 0 || mark > 100)
            throw new IllegalArgumentException("Marks must be 0-100");

        student.getMarks().add(mark);
        calculateAggregateAndGrade(student);
    }

    private void calculateAggregateAndGrade(Student student) {
        double total = 0;
        for (double m : student.getMarks()) {
            total += m;
        }

        double avg = total / student.getMarks().size();
        student.setAggregate(avg);

        if (avg >= 90) student.setGrade('A');
        else if (avg >= 75) student.setGrade('B');
        else if (avg >= 60) student.setGrade('C');
        else student.setGrade('D');
    }
}
