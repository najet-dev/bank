package fr.najet.bank.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
@Entity
@DiscriminatorValue("CC")
public class CurrentAccount extends Account {
    public double overDraft;

    public CurrentAccount() {
        super();
    }

    public CurrentAccount( Date dateCreation, double balance, Client client, double overDraft) {
        super.id = id;
        super.dateCreation = dateCreation;
        super.balance = balance;
        super.client = client;
        this.overDraft = overDraft;
    }
}
