package gr.uniwa.apice.Domain;

import gr.uniwa.apice.Enum.TheoryCourses;

import javax.persistence.*;

@Entity
@Table(name = "theorycourse")
public class TheoryCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int theoryCourseId;
    @Version
    private int version;
    @Enumerated(EnumType.STRING)
    private TheoryCourses courseDetails;
    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

    public TheoryCourse() {
    }

    public TheoryCourse(int theoryCourseId, int version, TheoryCourses courseDetails, Student student) {
        this.theoryCourseId = theoryCourseId;
        this.version = version;
        this.courseDetails = courseDetails;
        this.student = student;
    }

    public TheoryCourse(TheoryCourses courseDetails, Student student) {
        this.courseDetails = courseDetails;
        this.student = student;
    }

    public TheoryCourse(TheoryCourses courseDetails) {
        this.courseDetails = courseDetails;
    }

    public int getTheoryCourseId() {
        return theoryCourseId;
    }

    public void setTheoryCourseId(int theoryCourseId) {
        this.theoryCourseId = theoryCourseId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public TheoryCourses getCourseDetails() {
        return courseDetails;
    }

    public void setCourseDetails(TheoryCourses courseDetails) {
        this.courseDetails = courseDetails;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
