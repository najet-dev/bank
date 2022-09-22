package fr.najet.bank.entities;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Transactional
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name ="Type", discriminatorType = DiscriminatorType.STRING,length = 2)
@Table(name= "accounts")
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String type;
    protected Date createdAt = new Date();
    protected double balance;

    @ManyToOne
    //@JoinColumn(name="userId")
    protected User user;
    @OneToMany(mappedBy = "account",fetch=FetchType.LAZY)
    public List<AccountOperation> accountOperations = new ArrayList<>();

    public Account() {
        super();
    }

    public Account(String type, double balance, User user) {
        this.type = type;
        this.balance = balance;
        this.user = user;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user= user;
    }


    public List<AccountOperation> getAccountOperations() {
        return accountOperations;
    }

    public void setAccountOperations(List<AccountOperation> accountOperations) {
        this.accountOperations = accountOperations;
    }
}
