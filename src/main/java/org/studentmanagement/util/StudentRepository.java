package org.studentmanagement.util;

import org.studentmanagement.models.Student;
import org.studentmanagement.service.StudentService;

import java.io.*;
import java.util.ArrayList;

public class StudentRepository {

    private static final String FILE_PATH = "src/main/java/data/students.txt";

    // Save = overwrite database
    public static void saveStudents(ArrayList<Student> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Student s : students) {
                writer.write(s.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    // Load all students from file

    //It reads a file line by line, extracts name and marks,
    // creates Student objects, and returns them in a list
    public static ArrayList<Student> loadStudents(StudentService service) {
        ArrayList<Student> list = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) return list;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {

                // Name: John Marks: [10.0, 20.0] Aggregate: 15.0 Grade: D
                String name = line.split("Marks:")[0]           //split where Marks:
                        .replace("Name:", "").trim();   //remove spaces from name

                Student s = new Student(name);   //name: "Bob"  create Student object ß

                int start = line.indexOf("[");
                int end = line.indexOf("]");

                if (start != -1 && end != -1) {
                    String marksStr = line.substring(start + 1, end);
                    for (String m : marksStr.split(",")) {
                        if (!m.trim().isEmpty()) {
                            service.addMarks(s, Double.parseDouble(m.trim()));
                        }
                    }
                }
                list.add(s);
            }
        } catch (IOException e) {
            System.out.println("Read error: " + e.getMessage());
        }
        return list;
    }

    public static void displayStudents() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            System.out.println("No students available.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.lines().forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Read error: " + e.getMessage());
        }
    }
}
