/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ramirez_tipperapp.ramirez_finalexam;
import java.util.List;

/**
 *
 * @author angelramirez-rivera
 */
public class Controller {
Model model = new Model();
View view = new View();

    public Controller(Model model, View view) {
    this.model = model;
    this.view = view;
}

    public void registerStudent() {
    System.out.print("Enter the number of students to register: ");
    int numStudents = view.scanner.nextInt();
    
    for (int i = 0; i < numStudents; i++) {
        Model.Student student = view.getStudentInfo();
        model.addStudent(student);
    }
    
    view.printMessage(numStudents + " student(s) registered.");
}
    
 public void addGrade() {
    view.printMessage("Adding grade to a student...");
    String id = view.getStudentId();
    Model.Student student = model.getStudentById(id);
    if (student != null) {
        int grade = view.getGrade();
        String letterGrade = calculateLetterGrade(grade);
        student.setLetterGrade(letterGrade);
        view.printMessage("Grade added successfully!");
    } else {
        view.printMessage("Student not found!");
    }
}private void addGradeToStudent() {
    List<Model.Student> students = model.getStudents();
    if (students.isEmpty()) {
        view.printMessage("No students registered yet.");
    } else {
        view.printStudentList(students);
        System.out.print("Enter the index of the student to add grade: ");
        int index = view.getMenuChoice();
        if (index >= 0 && index < students.size()) {
            Model.Student student = students.get(index);
            System.out.print("Enter the new grade: ");
            int grade = view.getMenuChoice();
            String letterGrade = calculateLetterGrade(grade);
            student.setLetterGrade(letterGrade);
            view.printMessage("Grade added successfully.");
        } else {
            view.printMessage("Invalid student index. Please try again.");
        }
    }
}

private String calculateLetterGrade(int grade) {
    if (grade >= 95) {
        return "A";
    } else if (grade >= 90) {
        return "A-";
    } else if (grade >= 85) {
        return "B+";
    } else if (grade >= 80) {
        return "B";
    } else if (grade >= 75) {
        return "B-";
    } else if (grade >= 70) {
        return "C+";
    } else if (grade >= 65) {
        return "C";
    } else if (grade >= 60) {
        return "D";
    } else {
        return "F";
    }
}

    public void calculateClassAverage() {
        double classAverage = model.calculateClassAverage();
        view.printClassAverage(classAverage);
    }

    public void printStudentList() {
        List<Model.Student> students = model.getStudents();
        view.printStudentList(students);
    }

    
    public void run() {
        int choice;
        do {
            view.printMenu();
            choice = view.getMenuChoice();
            switch (choice) {
                case 1:
                    registerStudent();
                    break;
                case 2:
                    addGradeToStudent();
                    break;
                case 3:
                    calculateClassAverage();
                    break;
                case 4:
                    printStudentList();
                    break;
                case 5:
                    view.printMessage("Exiting program...");
                    break;
                default:
                    view.printMessage("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        } while (choice != 5);
    }
}
