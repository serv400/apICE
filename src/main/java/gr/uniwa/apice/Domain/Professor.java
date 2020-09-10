package gr.uniwa.apice.Domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "professor")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int profId;
    private String fname;
    private String lname;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Course> coursesDoing;

    public Professor() {
    }

    public int getProfId() {
        return profId;
    }

    public void setProfId(int profId) {
        this.profId = profId;
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

    public List<Course> getCoursesDoing() {
        return coursesDoing;
    }

    public void setCoursesDoing(List<Course> coursesDoing) {
        this.coursesDoing = coursesDoing;
    }
}
