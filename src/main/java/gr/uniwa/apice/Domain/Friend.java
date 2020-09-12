package gr.uniwa.apice.Domain;

import javax.persistence.*;

@Entity
@Table(name = "friend")
public class Friend extends Student{

    public Friend(String fname, String lname, String code, String username) {
        super(fname, lname, code, username);
    }

    public Friend() {

    }

}
