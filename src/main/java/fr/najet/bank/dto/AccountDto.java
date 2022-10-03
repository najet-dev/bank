package fr.najet.bank.dto;

import fr.najet.bank.entities.AccountOperation;
import fr.najet.bank.entities.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountDto {
  protected int id;
  public String type;
  protected Date createdAt = new Date();
  protected double balance;

  protected User user;

  public List<AccountOperation> accountOperations = new ArrayList<>();

  protected double overDraft;

  protected double interestRate;

  public AccountDto() {
  }

  public AccountDto(String type, double balance, User user, double overDraft, double interestRate) {
    this.type = type;
    this.balance = balance;
    this.user = user;
    this.overDraft = overDraft;
    this.interestRate = interestRate;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<AccountOperation> getAccountOperations() {
    return accountOperations;
  }
  public void setAccountOperations(List<AccountOperation> accountOperations) {
    this.accountOperations = accountOperations;
  }

  public double getOverDraft() {
    return overDraft;
  }

  public void setOverDraft(double overDraft) {
    this.overDraft = overDraft;
  }

  public double getInterestRate() {
    return interestRate;
  }

  public void setInterestRate(double interestRate) {
    this.interestRate = interestRate;
  }

}



