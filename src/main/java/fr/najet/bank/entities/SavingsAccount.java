package fr.najet.bank.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("SA")
public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount() {
        super();

    }
    public SavingsAccount(String id, String type, Date createdAt, double balance, User user, List<AccountOperation> payments, double interestRate) {
        super(id, createdAt, balance, user, payments);
        this.interestRate = interestRate;
    }
    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
