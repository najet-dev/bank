package fr.najet.bank.entities;

import javax.persistence.Entity;

@Entity
public class CurrentAccount extends Account {
  public double overDraft = 0;

  public CurrentAccount() {
    super();
  }

  public CurrentAccount(double balance, User user, double overDraft) {
    super();
    this.overDraft = overDraft;
  }

  public double getOverDraft() {
    return overDraft;
  }

  public void setOverDraft(double overDraft) {
    this.overDraft = overDraft;
  }

}
