 import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    int age;
    String course;
    double marks;

    Student(int id, String name, int age, String course, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.marks = marks;
    }

    void display() {
        System.out.println("-----------------------------");
        System.out.println("ID     : " + id);
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + age);
        System.out.println("Course : " + course);
        System.out.println("Marks  : " + marks);
        System.out.println("-----------------------------");
    }
}

public class StudentMangementSystem {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n==============================");
            System.out.println("  Student Management System  ");
            System.out.println("==============================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.println("==============================");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent();    break;
                case 2: viewStudents();  break;
                case 3: searchStudent(); break;
                case 4: updateStudent(); break;
                case 5: deleteStudent(); break;
                case 6: System.out.println("Exiting... Goodbye!"); break;
                default: System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);
    }

    
    static void addStudent() {
        System.out.println("\n--- Add New Student ---");
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        
        for (Student s : students) {
            if (s.id == id) {
                System.out.println("Student with this ID already exists!");
                return;
            }
        }

        sc.nextLine(); 
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Course: ");
        String course = sc.nextLine();
        System.out.print("Enter Marks (0-100): ");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, age, course, marks));
        System.out.println("✔ Student added successfully!");
    }

    
    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("\nNo students found.");
            return;
        }
        System.out.println("\n--- All Students (" + students.size() + ") ---");
        for (Student s : students) {
            s.display();
        }
    }

    static void searchStudent() {
        System.out.print("\nEnter Student ID to search: ");
        int id = sc.nextInt();
        for (Student s : students) {
            if (s.id == id) {
                System.out.println("\n--- Student Found ---");
                s.display();
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }


    static void updateStudent() {
        System.out.print("\nEnter Student ID to update: ");
        int id = sc.nextInt();
        for (Student s : students) {
            if (s.id == id) {
                sc.nextLine();
                System.out.print("Enter New Name (" + s.name + "): ");
                s.name = sc.nextLine();
                System.out.print("Enter New Age (" + s.age + "): ");
                s.age = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter New Course (" + s.course + "): ");
                s.course = sc.nextLine();
                System.out.print("Enter New Marks (" + s.marks + "): ");
                s.marks = sc.nextDouble();
                System.out.println("✔ Student updated successfully!");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    
    static void deleteStudent() {
        System.out.print("\nEnter Student ID to delete: ");
        int id = sc.nextInt();
        boolean removed = students.removeIf(s -> s.id == id);
        if (removed) {
            System.out.println("✔ Student deleted successfully!");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }
}