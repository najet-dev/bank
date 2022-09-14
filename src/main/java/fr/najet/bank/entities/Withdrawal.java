package fr.najet.bank.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("W")
public class Withdrawal extends Operation {

    public Withdrawal() {
        super();
    }
    public Withdrawal( Date dateOperation, double amount, Account account) {
        super(dateOperation, amount, account);
    }



}
