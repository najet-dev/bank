package fr.najet.bank.entities;

import javax.persistence.Entity;

@Entity
public class SavingsAccount extends Account {
    private double interestRate = 0;

    public SavingsAccount() {
        super();
    }

    public SavingsAccount(double balance, User user, double interestRate) {
        super("SavingsAccount", balance, user);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
