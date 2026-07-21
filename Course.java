public class Course {

    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private int enrolled;
    private String schedule;

    public Course(String courseCode, String title, String description,
                  int capacity, String schedule) {

        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolled = 0;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getAvailableSeats() {
        return capacity - enrolled;
    }

    public boolean registerStudent() {

        if (enrolled < capacity) {
            enrolled++;
            return true;
        }

        return false;
    }

    public void removeStudent() {

        if (enrolled > 0)
            enrolled--;
    }

    @Override
    public String toString() {

        return "\nCourse Code : " + courseCode +
                "\nTitle       : " + title +
                "\nDescription : " + description +
                "\nSchedule    : " + schedule +
                "\nAvailable   : " + getAvailableSeats();
    }
}
