package org.studentmanagement.models;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private List<Double> marks = new ArrayList<>();
    private double aggregate;
    private char grade;

    public Student(String name) {
        this.name = name;
    }

    // Getters & Setters
    public String getName() {
        return name;
    }

    public List<Double> getMarks() {
        return marks;
    }

    public double getAggregate() {
        return aggregate;
    }

    public void setAggregate(double aggregate) {
        this.aggregate = aggregate;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    // For file storage
    public String toFileString() {
        return "Name: " + name +
                " Marks: " + marks +
                " Aggregate: " + aggregate +
                " Grade: " + grade;
    }

    @Override
    public String toString() {
        return toFileString();
    }
}
