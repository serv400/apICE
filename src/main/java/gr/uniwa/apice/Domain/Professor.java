package gr.uniwa.apice.Domain;

import java.util.List;

public class Professor {
    private int profId;
    private String fname;
    private String lname;
    private List<Course> coursesDoing;

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
