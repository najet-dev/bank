package fr.najet.bank.dto;

import java.util.List;

public class AccountHistoryDto {
  private int accountId;

  private double balance;
  private int currentPage;
  private int totalPages;
  private int pageSize;
  private List<AccountOperationDto> accountOperations;

  public AccountHistoryDto() {
  }

  public AccountHistoryDto(int accountId, double balance, int currentPage, int totalPages, int pageSize,
                           List<AccountOperationDto> accountOperations) {
    this.accountId = accountId;
    this.balance = balance;
    this.currentPage = currentPage;
    this.totalPages = totalPages;
    this.pageSize = pageSize;
    this.accountOperations = accountOperations;
  }
  public int getId() {
    return accountId;
  }
  public double getBalance() {
    return balance;
  }
  public void setBalance(double balance) {
    this.balance = balance;
  }
  public void setId(int accountId) {
    this.accountId = accountId;
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

  public List<AccountOperationDto> getAccountOperations() {
    return accountOperations;
  }

  public void setAccountOperations(List<AccountOperationDto> accountOperations) {
    this.accountOperations = accountOperations;
  }

}


