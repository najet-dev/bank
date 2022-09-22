package fr.najet.bank.entities;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@Entity
//@DiscriminatorValue("SA")
public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount() {
        super();

    }

    public SavingsAccount(int id, Date createdAt, double balance, User user, List<AccountOperation> accountOperations, double overDraft, double interestRate) {
        super.id = id;
        super.createdAt = createdAt;
        super.balance = balance;
        super.user = user;
        super.accountOperations = accountOperations;
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
