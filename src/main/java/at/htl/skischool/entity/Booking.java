package at.htl.skischool.entity;

public class Booking {

    private Integer id;
    private Skistudent student;
    private Course course;

    public Booking(Skistudent student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Booking(Integer id, Skistudent student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Booking() {
    }

    public Skistudent getStudent() {
        return student;
    }

    public void setStudent(Skistudent student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Booking:" +
                "student=" + student.getLastname() +
                ", course=" + course.getName();
    }
}
