package fr.najet.bank.dto;

import fr.najet.bank.entities.AccountOperation;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class AccountHistoryDto {
    private int id;
    private double balance;
    private int currentPage;
    private int totalPages;
    private int pageSize;
    private List<AccountOperationDto> accountOperationDtos;

    public AccountHistoryDto() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
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

    public List<AccountOperationDto> getAccountOperationDtos() {
        return accountOperationDtos;
    }

    public void setAccountOperationDtos(List<AccountOperationDto> accountOperationDTOS) {
        this.accountOperationDtos = accountOperationDtos;
    }

    public AccountOperationDto fromAccountOperation(AccountOperation accountOperation) {
        AccountOperationDto accountOperationDto = new AccountOperationDto();
        BeanUtils.copyProperties(accountOperation, accountOperationDto);
        return accountOperationDto;
    }

}


