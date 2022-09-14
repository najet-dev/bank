package fr.najet.bank.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name="clients")
public class Client extends User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    protected String lastName;
    protected String firstName;
    protected String email;
    @OneToMany(mappedBy = "client",fetch=FetchType.LAZY)
    public List<Account> accounts;

    public Client() {
        super();

    }
    public Client(String userName, String password, int role, String lastName, String firstName, String email, List<Account> accounts) {
        super.userName = userName;
        super.role = role;
        super.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
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

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

}


