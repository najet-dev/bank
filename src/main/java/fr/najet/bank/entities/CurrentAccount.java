package fr.najet.bank.entities;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@Entity
//@DiscriminatorValue("CA")
public class CurrentAccount extends Account {
    private double overDraft; //decouvert

    public CurrentAccount() {
        super();
    }



    public CurrentAccount(int id, String type, Date createdAt, double balance, User user, String lastName, String firstName, String email, String userName, int role, String password, List<AccountOperation> accountOperations, double overDraft) {
        super.id = id;
        super.createdAt = createdAt;
        super.balance = balance;
        super.user = user;
        super.accountOperations = accountOperations;
        this.overDraft = overDraft;
    }

    public double getOverDraft() {
        return overDraft;
    }

    public void setOverDraft(double overDraft) {
        this.overDraft = overDraft;
    }
}
