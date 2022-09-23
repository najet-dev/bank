package fr.najet.bank.entities;

import fr.najet.bank.enums.OperationTypeEnum;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;

@Entity
@Transactional
public class AccountOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Date createdAt = new Date();

    private String description;

    public double amount;

   @Enumerated(EnumType.STRING)
    public OperationTypeEnum type;
    @ManyToOne
    public Account account;


    public AccountOperation(){}
    public AccountOperation( Date createdAt,String description, double amount,OperationTypeEnum type, Account account) {
        this.createdAt = createdAt;
        this.description = description;
        this.amount = amount;
        this.account = account;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public OperationTypeEnum getType() {
        return type;
    }

    public void setType(OperationTypeEnum type) {
        this.type = type;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
