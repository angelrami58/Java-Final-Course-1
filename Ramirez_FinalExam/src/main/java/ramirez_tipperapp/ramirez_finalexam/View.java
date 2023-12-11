/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ramirez_tipperapp.ramirez_finalexam;
import java.util.Scanner;
import java.util.List;
/**
 *
 * @author angelramirez-rivera
 */
public class View {

    public Scanner scanner = new Scanner(System.in);

    public void printMenu() {
        System.out.println("1. Register student");
        System.out.println("2. Add grade to student");
        System.out.println("3. Calculate class average grade");
        System.out.println("4. Print list of students");
        System.out.println("5. Exit program");
        System.out.println("5. Search for a student");
        System.out.print("Enter your choice (1-6): ");
    }

    public int getMenuChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return choice;
    }

    public Model.Student getStudentInfo() {
        System.out.print("Enter student's first name: ");
        String firstName = scanner.next();
        System.out.print("Enter student's last name: ");
        String lastName = scanner.next();
        System.out.print("Enter student's ID: ");
        String id = scanner.next();
        System.out.println("Enter 10 assessment grades: ");
        int[] grades = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.printf("Grade %d: ", i + 1);
            grades[i] = scanner.nextInt();
        }
        scanner.nextLine(); // Consume the newline character
        return new Model().new Student(firstName, lastName, id, grades);
    }

    public void printClassAverage(double classAverage) {
        System.out.printf("Class average grade: %.2f%%\n", classAverage);
    }

    public void printStudentList(List<Model.Student> students) {
        System.out.println("List of students:");
        for (Model.Student student : students) {
            System.out.println(student.toString());
        }
    }
      public String getStudentId() {
        System.out.print("Enter the student ID: ");
        return scanner.nextLine();
    }

    public int getGrade() {
        System.out.print("Enter the grade (out of 50): ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
  

    public String getSearchQuery() {
        System.out.print("Enter search query: ");
        return scanner.nextLine();
    }
}

