package fr.najet.bank.entities;

import fr.najet.bank.dto.UserDto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("CA")
public class CurrentAccount extends Account {
    private double overDraft; //decouvert

    public CurrentAccount(String id, Date createdAt, double balance, UserDto userDto, double overDraft) {
        super();
    }

    public CurrentAccount(String id, Date createdAt, double balance, User user, List<AccountOperation> payments, double overDraft) {
        super(id, createdAt, balance, user, payments);
        this.overDraft = overDraft;
    }

    public double getOverDraft() {
        return overDraft;
    }

    public void setOverDraft(double overDraft) {
        this.overDraft = overDraft;
    }
}
