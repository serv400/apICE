package gr.uniwa.apice.Domain;


import gr.uniwa.apice.Enum.Courses;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int courseId;
    @Version
    private int version;
    @Enumerated(EnumType.STRING)
    private Courses courseDetails;
    private String dateOfHappening;
    private String className;
    @ManyToOne(cascade = CascadeType.ALL)
    private Professor professor;
    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

    public Course() {
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Courses getCourseDetails() {
        return courseDetails;
    }
    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getDateOfHappening() {
        return dateOfHappening;
    }

    public void setDateOfHappening(String dateOfHappening) {
        this.dateOfHappening = dateOfHappening;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setCourseDetails(Courses courseDetails) {
        this.courseDetails = courseDetails;
    }
}
