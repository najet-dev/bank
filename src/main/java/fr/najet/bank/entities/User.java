package fr.najet.bank.entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String userName;
    protected int role;
    protected String password;

    public User() {

    }
    public User(int id, String userName, int role, String password) {
        this.userName = userName;
        this.role = role;
        this.password = password;
    }

    public int getUserId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }


    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
