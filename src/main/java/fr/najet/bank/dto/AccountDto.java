package fr.najet.bank.dto;

import fr.najet.bank.entities.Account;
import fr.najet.bank.entities.AccountOperation;
import fr.najet.bank.entities.User;

import java.util.Date;
import java.util.List;

public class AccountDto {
    protected String id;
    protected Date createdAt;
    protected double balance;

    protected User user;
    public List<AccountOperation> payments;

    public AccountDto() {
    }

    public String getId() {
        return id;
    }


    public void setId(String id) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user= user;
    }

    public List<AccountOperation> getPayments() {
        return payments;
    }


    public static Account addAccount(AccountDto accountDto) {
        Account account = new Account(accountDto.getId(), accountDto.getCreatedAt(), accountDto.getBalance(), accountDto.getUser(), accountDto.getPayments());
        return account;
    }


}
