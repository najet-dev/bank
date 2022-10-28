package fr.najet.bank.dto;

import org.springframework.data.domain.Page;

public class AccountHistoryDto {
  private int accountId;
  private double balance;

  private int currentPage;

  private int totalPages;

  private int pageSize;
  private Page<AccountOperationDto> accountOperationsDto;

  public AccountHistoryDto() {
  }

  public AccountHistoryDto(int accountId, double balance,int currentPage, int totalPages, int pageSize, Page<AccountOperationDto> accountOperationsDto) {
    this.accountId = accountId;
    this.balance = balance;
    this.currentPage = currentPage;
    this.totalPages = totalPages;
    this.pageSize = pageSize;
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

  public int getCurrentPage() {
    return currentPage;
  }
  public void setCurrentPage(int currentPage) {
    this.currentPage = currentPage;
  }

  public int getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(int totalPages) {
    this.totalPages = totalPages;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
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


