package fr.najet.bank.entities;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Transactional
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name ="Type", discriminatorType = DiscriminatorType.STRING,length = 2)
@Table(name= "accounts")
public class Account {
    @Id
    protected String id;


    protected Date createdAt;
    protected double balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userId")
    protected User user;
    @OneToMany(mappedBy = "account",fetch=FetchType.LAZY)
    public List<AccountOperation> payments = new ArrayList<>();

    public Account() {
    }
    public Account(String id, Date createdAt, double balance, User user, List<AccountOperation> payments) {
        this.id = id;
        this.createdAt = createdAt;
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

    public List<AccountOperation> getPayments() {
        return payments;
    }

    public void setPayments(List<AccountOperation> payments) {
        this.payments = payments;
    }
}
