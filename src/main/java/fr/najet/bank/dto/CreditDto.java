package fr.najet.bank.dto;

import fr.najet.bank.entities.Account;
import java.util.Date;

public class CreditDto {
  public int id;
  public Date createdAt = new Date();

  public double amount;

  public Account account;
  private String description;

  public CreditDto() {
    super();
  }

  public CreditDto(int id, Date createdAt, double amount, Account account, String description) {
    this.id = id;
    this.createdAt = createdAt;
    this.amount = amount;
    this.account = account;
    this.description = description;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }


  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}


