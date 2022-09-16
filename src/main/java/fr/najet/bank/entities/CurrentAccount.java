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

    public CurrentAccount( Date dateCreation, double balance, User user, double overDraft) {
        this.overDraft = overDraft;
    }
}
