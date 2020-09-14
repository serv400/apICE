package gr.uniwa.apice.Domain;


import gr.uniwa.apice.Enum.Courses;

import javax.persistence.*;
import java.util.Calendar;
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
    private Calendar dateOfHappening;
    private String className;
    @ManyToOne(cascade = CascadeType.ALL)
    private Professor professor;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Student> studentSet;

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

    public Calendar getDateOfHappening() {
        return dateOfHappening;
    }

    public void setDateOfHappening(Calendar dateOfHappening) {
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

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    public void setCourseDetails(Courses courseDetails) {
        this.courseDetails = courseDetails;
    }
}
