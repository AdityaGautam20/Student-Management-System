import model.Student;
import service.studentService;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        studentService service = new studentService();
        Scanner in = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. View All Students");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = in.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = in.nextInt();
                    in.nextLine();

                    System.out.print("Enter Name: ");
                    String name = in.nextLine();

                    System.out.print("Enter Age: ");
                    int age = in.nextInt();
                    in.nextLine();

                    System.out.print("Enter Email: ");
                    String email = in.nextLine();

                    System.out.print("Enter Course: ");
                    String course = in.nextLine();

                    Student s = new Student(id, name, age, email, course);
                    service.addStudent(s);
                    System.out.println("✅ Student added.");
                    break;

                case 2:
                    System.out.print("Enter ID of student to update: ");
                    int updateId = in.nextInt();
                    in.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = in.nextLine();

                    System.out.print("Enter New Age: ");
                    int newAge = in.nextInt();
                    in.nextLine();

                    System.out.print("Enter New Email: ");
                    String newEmail = in.nextLine();

                    System.out.print("Enter New Course: ");
                    String newCourse = in.nextLine();

                    Student updatedStudent = new Student(updateId, newName, newAge, newEmail, newCourse);
                    boolean updatedResult = service.updateStudent(updateId, updatedStudent);
                    System.out.println(updatedResult ? "✅ Updated successfully." : "❌ Student not found.");
                    break;

                case 3:
                    System.out.print("Enter ID to delete: ");
                    int deleteID = in.nextInt();
                    boolean deleted = service.deleteStudent(deleteID);
                    System.out.println(deleted ? "✅ Deleted successfully." : "❌ Student not found.");
                    break;

                case 4:
                    System.out.print("Enter ID to search: ");
                    int searchID = in.nextInt();

                    Student found = service.searchStudent(searchID);

                    if (found != null) {
                        System.out.println("✅ Student found: \n" + found);
                    }
                    else {
                        System.out.println("❌ Student not found.");
                    }

                    sleep(2000);
                    break;

                case 5:
                    System.out.println("📋 List of all Students:");

                    for (Student student : service.getAllStudents()) {
                        System.out.println(student);
                    }

                    sleep(2000);
                    break;

                case 6:
                    running = false;
                    System.out.println("👋 Exiting...");
                    break;

                default:
                    System.out.println("❌ Invalid choice.");
                    sleep(2000);
            }
        }
        in.close();
    }
}
