package gr.uniwa.apice.Domain;

import gr.uniwa.apice.Enum.TheoryCourses;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;
    @Column(nullable = false)
    private String fname;
    @Column(nullable = false)
    private String lname;
    @Column(nullable = false,unique = true)
    private String code;
    @Column(nullable = false,unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    private String role="ROLE_USER";
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private Set<Course> courseSet;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private Set<TheoryCourse> theoryCourseSet;

    public Student(String fname, String lname, String code, String username) {
        this.fname = fname;
        this.lname = lname;
        this.code = code;
        this.username = username;
    }

    public Student(String fname, String lname, String code) {
        this.fname = fname;
        this.lname = lname;
        this.code = code;
    }

    public Student(String fname, String lname, String code, String username, String password, String role) {
        this.fname = fname;
        this.lname = lname;
        this.code = code;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Student() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Course> getCourseSet() {
        return courseSet;
    }

    public void setCourseSet(Set<Course> courseSet) {
        this.courseSet = courseSet;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void addCourseToSet(Course course){
        courseSet.add(course);
    }

    public Set<TheoryCourse> getTheoryCourseSet() {
        return theoryCourseSet;
    }

    public void setTheoryCourseSet(Set<TheoryCourse> theoryCourseSet) {
        this.theoryCourseSet = theoryCourseSet;
    }

    public void addTheoryCourseToSet(TheoryCourse course){
            theoryCourseSet.add(course);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", code='" + code + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", courseSet=" + courseSet +
                ", theoryCourseSet=" + theoryCourseSet +
                '}';
    }
}
