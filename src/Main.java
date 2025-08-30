package src;

import java.util.Scanner;
import src.models.*;
import src.services.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService studentService = new StudentService();
        GradeService gradeService = new GradeService();
        ReportService reportService = new ReportService(); // 👈 correct usage
        addSubjects subject = new addSubjects();

        while (true) {
            try {
                System.out.println("\n--- Student Grade Management ---");
                System.out.println("1. Add Student");
                System.out.println("2. Add Grade");
                System.out.println("3. Add Subject");
                System.out.println("4. Yours Grade");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int ch = sc.nextInt();
                sc.nextLine();

                switch (ch) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter department: ");
                        String dept = sc.nextLine();
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Section: ");
                        String section = sc.nextLine();
                        studentService.addStudent(new Student(id, name, dept, section));
                        break;

                    case 2:
                        System.out.print("Enter student ID: ");
                        int sid = sc.nextInt();
                        System.out.print("Enter subject ID: ");
                        int subid = sc.nextInt();
                        System.out.print("Enter marks: ");
                        int marks = sc.nextInt();
                        String grade = (marks >= 90) ? "A" : (marks >= 75) ? "B" : (marks >= 60) ? "C" : "F";
                        gradeService.addGrade(new Grade(sid, subid, marks, grade));
                        break;

                    case 3:
                        System.out.println("Enter Subject ID: ");
                        int subId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Subject Name: ");
                        String subName = sc.nextLine();
                        subject.addSubject(new Subject(subId, subName));
                        break;
                    	
                    case 4:
                        System.out.print("Enter Student ID to view grades: ");
                        int studentId = sc.nextInt();
                        sc.nextLine();
                        reportService.showGradesForStudent(studentId);  // ✅ Correct call
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Invalid Input");
                sc.nextLine();
            }
        }
    }
}
