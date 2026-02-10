package org.studentmanagement;

import org.studentmanagement.controller.StudentController;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentController controller = new StudentController();

        System.out.println("===== Student Management System =====");

        while (true) {
            showMenu();
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> controller.createStudent(sc);
                case 2 -> controller.addMarks(sc);
                case 3 -> controller.removeStudent(sc);
                case 4 -> controller.searchStudent(sc);
                case 5 -> controller.displayFromFile();
                case 6 -> {
                    System.out.println("Bye 👋");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    public static void showMenu() {
        System.out.println("------------------------------------");
        System.out.println("1. Create Student");
        System.out.println("2. Add Marks");
        System.out.println("3. Remove Student");
        System.out.println("4. Search Student");
        System.out.println("5. Display All Students");
        System.out.println("6. Exit");
        System.out.println("------------------------------------");
    }
}
