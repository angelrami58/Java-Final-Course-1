/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ramirez_tipperapp.ramirez_finalexam;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author angelramirez-rivera
 */
public class Model {

    private List<Student> students;

    public Model() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public List<Student> getStudents() {
        return students;
    }

    public double calculateClassAverage() {
        if (students.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;
        for (Student student : students) {
            total += student.getAverageGrade();
        }

        return total / students.size();
    }

    class Student {
        private String firstName;
        private String lastName;
        private String id;
        private int[] grades;
        private String letterGrade;

        public Student(String firstName, String lastName, String id, int[] grades) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.id = id;
            this.grades = grades;
            calculateLetterGrade();
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getId() {
            return id;
        }

        public int[] getGrades() {
            return grades;
        }

        public double getAverageGrade() {
            if (grades.length == 0) {
                return 0.0;
            }

            int sum = 0;
            for (int grade : grades) {
                sum += grade;
            }

            return (double) sum / grades.length;
        }

        public String getLetterGrade() {
            return letterGrade;
        }

        public void setLetterGrade(String letterGrade) {
            this.letterGrade = letterGrade;
        }

        public void calculateLetterGrade() {
            double average = getAverageGrade();

            if (average >= 95) {
                letterGrade = "A";
            } else if (average >= 90) {
                letterGrade = "A-";
            } else if (average >= 85) {
                letterGrade = "B+";
            } else if (average >= 80) {
                letterGrade = "B";
            } else if (average >= 75) {
                letterGrade = "B-";
            } else if (average >= 70) {
                letterGrade = "C+";
            } else if (average >= 65) {
                letterGrade = "C";
            } else if (average >= 60) {
                letterGrade = "D";
            } else {
                letterGrade = "F";
            }
        }

        @Override
        public String toString() {
            return "Name: " + firstName + " " + lastName + ", ID: " + id + ", Average Grade: " + getAverageGrade() +
                    ", Letter Grade: " + letterGrade;
        }
    }
}
