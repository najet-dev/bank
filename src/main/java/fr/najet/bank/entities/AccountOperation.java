package fr.najet.bank.entities;

import fr.najet.bank.enums.OperationTypeEnum;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;

@Entity
@Transactional
@DiscriminatorValue("P")
public class AccountOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date operationDate;

    private int accountSource;

    private int accountDestination;
    private double amount;
    @Enumerated(EnumType.STRING)
    private OperationTypeEnum type;
    @ManyToOne
    public Account account;

    private String description;



    public AccountOperation(){}
    public AccountOperation(int id, OperationTypeEnum  type, Date operationDate, int accountSource, int accountDestination, double amount, Account account, String description) {
        this.id = id;
        this.type = type;
        this.operationDate = operationDate;
        this.accountSource = accountSource;
        this.accountDestination = accountDestination;
        this.amount = amount;
        this.account = account;
        this.description = description;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public  OperationTypeEnum  getType() {
        return type;
    }

    public void setType(OperationTypeEnum  type) {
        this.type = type;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public int getAccountSource() {
        return accountSource;
    }

    public int getAccountDestination() {
        return accountDestination;
    }

    public void setAccountDestination(int accountDestination) {
        this.accountDestination = accountDestination;
    }

    public void setAccountSource(int accountSource) {
        this.accountSource = accountSource;
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

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
