package fr.najet.bank.dto;

import fr.najet.bank.entities.Account;
import java.util.ArrayList;
import java.util.List;

public class AccountUserDto {
  protected int userId;
  public List<Account> accounts = new ArrayList<>();

  public AccountUserDto() {
  }

  public AccountUserDto(int userId, List<Account> accounts) {
    this.userId = userId;
    this.accounts = accounts;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public List<Account> getAccounts() {
    return accounts;
  }

  public void setAccounts(List<Account> accounts) {
    this.accounts = accounts;
  }
}
