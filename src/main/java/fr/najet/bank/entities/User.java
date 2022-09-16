package fr.najet.bank.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private  String lastName;
    private String firstName;
    private  String email;
    private  String userName;
    private int role;
    private  String password;

    @OneToMany(mappedBy = "user",fetch=FetchType.LAZY)
    private List<Account> accounts;

    public User() {

    }
    public User( int id, String lastName, String firstName, String email, String userName, int role, String password,  List<Account> accounts) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.userName = userName;
        this.role = role;
        this.password = password;
        this.accounts = accounts;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

}
