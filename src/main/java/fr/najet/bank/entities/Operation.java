package fr.najet.bank.entities;

import javax.persistence.*;
import java.util.Date;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type_Operation", discriminatorType = DiscriminatorType.STRING, length = 1)
@Table(name = "operations")
public abstract class Operation {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public Date operationDate;
    public double amount;
    @ManyToOne
    @JoinColumn(name="accountId")
    public Account account;

    public Operation() {
    }

    //constructor
    public Operation(Date operationDate, double amount, Account account) {
        this.operationDate= operationDate;
        this.amount = amount;
        this.account = account;
    }

    //getter and setter
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public Account getAccount() {
        return account;
    }
    public void setAccounts(Account account) {
        this.account = account;
    }
}
