package fr.najet.bank.entities;

import javax.persistence.Entity;

@Entity
public class CurrentAccount extends Account {
  public double overDraft = 0;

  public CurrentAccount() {
    super();
  }

  public CurrentAccount(String name, double balance, User user, double overDraft) {
    super("CurrentAccount", name, balance, user);
    this.overDraft = overDraft;
  }



  public double getOverDraft() {
    return overDraft;
  }

  public void setOverDraft(double overDraft) {
    this.overDraft = overDraft;
  }

}
