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
    protected String id;

    protected Date dateCreation;
    protected double balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="clientId")
    protected Client client;
    @OneToMany(mappedBy = "account",fetch=FetchType.LAZY)
    public List<Operation> operations;

    public Account() {
    }

    public Account(String id, Date dateCreation, double balance, Client client, List<Operation> operations) {
        this.id = id;
        this.dateCreation = dateCreation;
        this.balance = balance;
        this.client = client;
        this.operations = operations;
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

    public User getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }


}
