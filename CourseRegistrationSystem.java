import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegistrationSystem {

    ArrayList<Course> courses = new ArrayList<>();

    Student student;

    Scanner sc = new Scanner(System.in);

    public CourseRegistrationSystem() {

        student = new Student(101, "Jana");

        courses.add(new Course("CS101",
                "Java Programming",
                "Core Java",
                3,
                "Mon 10AM"));

        courses.add(new Course("CS102",
                "Data Structures",
                "DSA Basics",
                2,
                "Tue 2PM"));

        courses.add(new Course("CS103",
                "Database",
                "SQL & DBMS",
                2,
                "Wed 11AM"));
    }

    public void start() {

        int choice;

        do {

            System.out.println("\n====== COURSE REGISTRATION ======");

            System.out.println("1. View Courses");

            System.out.println("2. Register Course");

            System.out.println("3. Drop Course");

            System.out.println("4. View Registered Courses");

            System.out.println("5. Exit");

            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    displayCourses();

                    break;

                case 2:

                    register();

                    break;

                case 3:

                    drop();

                    break;

                case 4:

                    student.displayRegisteredCourses();

                    break;

                case 5:

                    System.out.println("Thank You!");

                    break;

                default:

                    System.out.println("Invalid Choice");
            }

        } while (choice != 5);
    }

    private void displayCourses() {

        for (Course c : courses)

            System.out.println(c);
    }

    private void register() {

        System.out.print("Enter Course Code : ");

        String code = sc.next();

        for (Course c : courses) {

            if (c.getCourseCode().equalsIgnoreCase(code)) {

                if (c.registerStudent()) {

                    student.registerCourse(c);

                    System.out.println("Course Registered Successfully");

                }

                else {

                    System.out.println("Course Full");

                }

                return;
            }
        }

        System.out.println("Course Not Found");
    }

    private void drop() {

        System.out.print("Enter Course Code : ");

        String code = sc.next();

        if (student.dropCourse(code))

            System.out.println("Course Dropped");

        else

            System.out.println("Course Not Registered");
    }

}
