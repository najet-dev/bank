package fr.najet.bank.dto;

import com.fasterxml.jackson.annotation.JsonValue;
import fr.najet.bank.entities.AccountOperation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountUserDto {

  public int userId;

  public String name;

  public String type;

  public Date createdAt = new Date();

  public double balance;

  public List<AccountOperation> accountOperations = new ArrayList<>();

  protected double overDraft;

  protected double interestRate;

  public AccountUserDto() {
  }

  public AccountUserDto(int userId,String name, String type, double balance, double overDraft, double interestRate) {
    this.userId = userId;
    this.name = name;
    this.type = type;
    this.balance = balance;
    this.overDraft = overDraft;
    this.interestRate = interestRate;
  }


  @JsonValue
  public int getUserId() {
    return userId;
  }

  public void setUser(int userId) {
    this.userId = userId;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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



