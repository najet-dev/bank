package fr.najet.bank.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
@Entity
@DiscriminatorValue("CE")
public class SavingsAccount extends Account {
    public double interetRate;

    public SavingsAccount() {
        super();
    }
    public SavingsAccount( Date dateCreation, double balance, Client client, double interetRate) {
        super.id = id;
        super.dateCreation = dateCreation;
        super.balance = balance;
        super.client = client;
        this.interetRate = interetRate;
    }

    public double getInteretRate() {
        return interetRate;
    }

    public void setInteretRate(double interetRate) {
        this.interetRate = interetRate;
    }
}
