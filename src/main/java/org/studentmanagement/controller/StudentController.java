package org.studentmanagement.controller;

import org.studentmanagement.models.Student;
import org.studentmanagement.service.StudentService;
import org.studentmanagement.util.StudentRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {

    private final StudentService service = new StudentService();
    private final ArrayList<Student> students;

    public StudentController() {
        students = StudentRepository.loadStudents(service); // load TextFile
    }

    // 1
    public void createStudent(Scanner sc) {
        System.out.print("Enter student name: ");
        String name = sc.nextLine().trim();

        if (findStudent(name) != null) {
            System.out.println("Student already exists!");
            return;
        }

        students.add(new Student(name));
        //autosave
        StudentRepository.saveStudents(students);
        System.out.println("Student created.");
    }

    // 2
    public void addMarks(Scanner sc) {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        Student s = findStudent(name);
        if (s == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("Enter total subjects: ");
        int subjects = sc.nextInt();

        for (int i = 1; i <= subjects; i++) {
            System.out.print("Enter marks " + i + ": ");
            double mark = sc.nextDouble();

            try {
                service.addMarks(s, mark);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                i--; // retry same subject
            }
        }
        sc.nextLine();

        // auto-save
        StudentRepository.saveStudents(students);
        System.out.println("Marks updated.");
    }


    // 3
    public void removeStudent(Scanner sc) {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        Student s = findStudent(name);
        if (s != null) {
            students.remove(s);
            //autosave
            StudentRepository.saveStudents(students);
            System.out.println("Student removed.");
        } else {
            System.out.println("Student not found!");
        }
    }

    // 4
    public void searchStudent(Scanner sc) {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        Student s = findStudent(name);
        System.out.println(s != null ? s : "Student not found!");
    }

    // 5
    public void displayFromFile() {
        StudentRepository.displayStudents();
    }

    private Student findStudent(String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name))
                return s;
        }
        return null;
    }


    /*  manual save method
        public void save() {
            StudentRepository.saveStudents(students);
            System.out.println("All changes saved to database.");
        }
    */


}
