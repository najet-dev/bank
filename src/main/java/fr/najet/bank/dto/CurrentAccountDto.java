package fr.najet.bank.dto;

import fr.najet.bank.entities.AccountOperation;
import fr.najet.bank.entities.User;
import java.util.Date;
import java.util.List;

public class CurrentAccountDto {

  private int id;
  private Date createdAt;
  private double balance;
  private UserDto userDto;
  private double overDraft;

  public CurrentAccountDto(String type, Date createdAt, double balance, User user,
                           List<AccountOperation> accountOperations, double overDraft) {
    super();
  }

  public CurrentAccountDto(int id, Date createdAt, double balance, UserDto userDto,
                           double overDraft) {
    this.id = id;
    this.createdAt = createdAt;
    this.balance = balance;
    this.userDto = userDto;
    this.overDraft = overDraft;
  }

  public CurrentAccountDto(Date createdAt, double balance, UserDto userDto, double overDraft) {
    this.createdAt = createdAt;
    this.balance = balance;
    this.userDto = userDto;
    this.overDraft = overDraft;
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

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public UserDto getUserDto() {
    return userDto;
  }

  public void setUserDto(UserDto userDto) {
    this.userDto = userDto;
  }

  public double getOverDraft() {
    return overDraft;
  }

  public void setOverDraft(double overDraft) {
    this.overDraft = overDraft;
  }


}
