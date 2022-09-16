package fr.najet.bank.entities;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Transactional
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name ="Type_Account", discriminatorType = DiscriminatorType.STRING,length = 2)
@Table(name= "accounts")
public class Account {
    @Id
    private String id;

    private Date dateCreation;
    private double balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userId")
    protected User user;
    @OneToMany(mappedBy = "account",fetch=FetchType.LAZY)
    public List<Payment> payments;

    public Account() {
    }

    public Account(String id, Date dateCreation, double balance, User user, List<Payment> payments) {
        this.id = id;
        this.dateCreation = dateCreation;
        this.balance = balance;
        this.user = user;
        this.payments = payments;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
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

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
