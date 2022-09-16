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
    public SavingsAccount(String id, Date dateCreation, double balance, User user, double interetRate) {
        this.interetRate = interetRate;
    }

    public double getInteretRate() {
        return interetRate;
    }

    public void setInteretRate(double interetRate) {
        this.interetRate = interetRate;
    }
}
