# Student Management System

A simple **Java-based console application** for managing student records, including creating students, adding marks, calculating grades, searching, deleting, and storing data persistently in a file.

---

## Table of Contents

- [Features](#features)
- [Project Structure](#project-structure)
- [Installation](#installation)
- [Usage](#usage)
- [Dataset File](#dataset-file)
- [Grades](#grades)
- [Notes](#notes)
- [License](#license)

---

## Features

- Create new student profiles
- Add marks for multiple subjects
- Calculate aggregate scores and assign grades automatically
- Search for students by name
- Remove students from memory and dataset
- Display all students stored in the dataset
- Save current in-memory students to file

---

## Project Structure

org.studentmanagement
├── Main.java # Main application with console menu
├── Student.java # Student class with marks, aggregate, and grade
└── FileService.java # File operations: save, load, update, and delete students


Dataset file location:

src/main/resources/Dataset.txt


---

## Installation

1. Clone the repository or copy the package to your Java project.
2. Ensure you have **Java 8+** installed.
3. Create the directory structure:

src/main/java/org/studentmanagement/
src/main/resources/


4. Place the `Dataset.txt` file (can be empty initially) inside `src/main/resources/`.

---

## Usage

1. Compile the Java classes:

```bash
javac -d out src/main/java/org/studentmanagement/*.java
Run the application:

java -cp out org.studentmanagement.Main
The application presents a console menu:

============= Student Management System =============

1. Create Student
2. Add Marks
3. Remove Student
4. Search Student
5. Display All Students
6. Exit
Select the desired option by entering the corresponding number.

Example Workflow
Create Student

Enter student name when prompted.

Add Marks

Enter student name.

Enter total number of subjects.

Enter marks for each subject (0–100).

Remove Student

Enter student name to remove them from memory and dataset.

Search Student

Enter student name to view marks, aggregate, and grade.

Display All Students

Shows all students stored in Dataset.txt.

Save

Saves all in-memory students to Dataset.txt.

Exit

Closes the program.

Dataset File
File location: src/main/resources/Dataset.txt

Each student is stored as:

Name: <student_name> | Marks: [mark1, mark2, ...] | Aggregate: XX.XX | Grade: X
Marks can be updated, and the file is overwritten with the latest data to avoid duplicates.

Grades
Aggregate Score	Grade
90+	A
75–89	B
60–74	C
<60	D



