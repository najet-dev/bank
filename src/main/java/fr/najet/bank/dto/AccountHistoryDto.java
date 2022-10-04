package fr.najet.bank.dto;

import org.springframework.data.domain.Page;

public class AccountHistoryDto {
  private int accountId;
  private double balance;
  private Page<AccountOperationDto> accountOperationsDto;

  public AccountHistoryDto() {
  }

  public AccountHistoryDto(int accountId, double balance, Page<AccountOperationDto> accountOperationsDto) {
    this.accountId = accountId;
    this.balance = balance;
    this.accountOperationsDto = accountOperationsDto;
  }

  public int getAccountId() {
    return accountId;
  }

  public void setAccountId(int accountId) {
    this.accountId = accountId;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }


  public Page<AccountOperationDto> getAccountOperationsDto() {
    return accountOperationsDto;
  }

  public void setAccountOperationsDto(
      Page<AccountOperationDto> accountOperationsDto) {
    this.accountOperationsDto = accountOperationsDto;
  }
}


