package fr.najet.bank.dto;

import fr.najet.bank.entities.Account;
import fr.najet.bank.entities.User;

import java.util.Date;

public class AccountOperationDto {
    public Long id;
    public Date createdAt = new Date();

    protected User user;

    public int accountSource;

    public int accountDestination;
    public double amount;
    public Account account;

    public AccountOperationDto(Date createdAt, User user, int accountSource, int accountDestination, double amount, Account account) {
        this.createdAt = createdAt;
        this.user = user;
        this.accountSource = accountSource;
        this.accountDestination = accountDestination;
        this.amount = amount;
        this.account = account;
    }
    public AccountOperationDto() {
        super();
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAccountSource() {
        return accountSource;
    }

    public void setAccountSource(int accountSource) {
        this.accountSource = accountSource;
    }

    public int getAccountDestination() {
        return accountDestination;
    }

    public void setAccountDestination(int accountDestination) {
        this.accountDestination = accountDestination;
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
}
