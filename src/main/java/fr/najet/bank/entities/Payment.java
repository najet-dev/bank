package fr.najet.bank.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
@Entity
@DiscriminatorValue("P")
public class Payment extends Operation {
    public Payment (){
        super();
    }

    public Payment(Date dateOperation, double amount, Account account) {

        super(dateOperation, amount, account);
    }
}
