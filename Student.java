import java.util.ArrayList;

public class Student {

    private int studentId;
    private String name;

    private ArrayList<Course> registeredCourses = new ArrayList<>();

    public Student(int studentId, String name) {

        this.studentId = studentId;
        this.name = name;
    }

    public void registerCourse(Course course) {

        registeredCourses.add(course);
    }

    public boolean dropCourse(String code) {

        for (Course c : registeredCourses) {

            if (c.getCourseCode().equalsIgnoreCase(code)) {

                c.removeStudent();

                registeredCourses.remove(c);

                return true;
            }
        }

        return false;
    }

    public void displayRegisteredCourses() {

        if (registeredCourses.isEmpty()) {

            System.out.println("No Registered Courses");

            return;
        }

        System.out.println("\nRegistered Courses");

        for (Course c : registeredCourses) {

            System.out.println(c.getCourseCode());
        }
    }
}
