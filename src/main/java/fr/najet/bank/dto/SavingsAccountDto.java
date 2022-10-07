package fr.najet.bank.dto;

import java.util.Date;

public class SavingsAccountDto {
  private int id;
  private Date createdAt;
  private double balance;

  private UserDto userDto;

  private double interestRate;

  public SavingsAccountDto() {
    super();
  }

  public SavingsAccountDto(int id, String type, Date createdAt, double balance, UserDto userDto,
                           double interestRate) {
    this.id = id;
    this.createdAt = createdAt;
    this.balance = balance;
    this.userDto = userDto;
    this.interestRate = interestRate;
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

  public double getInterestRate() {
    return interestRate;
  }

  public void setInterestRate(double interestRate) {
    this.interestRate = interestRate;
  }

  public void setType(String simpleName) {
  }
}

