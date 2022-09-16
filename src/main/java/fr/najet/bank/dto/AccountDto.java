package fr.najet.bank.dto;

import fr.najet.bank.entities.Account;
import fr.najet.bank.entities.Payment;
import fr.najet.bank.entities.User;

import java.util.Date;
import java.util.List;

public class AccountDto {
    public String id;
    public Date dateCreation;
    public double balance;

    public User user;
    public List<Payment> payments;

    public AccountDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public double getBalance() {
        return balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public static Account addAccount(AccountDto accountDto) {
        Account account = new Account(accountDto.getId(), accountDto.getDateCreation(), accountDto.getBalance(), accountDto.getUser(), accountDto.getPayments());
        return account;
    }


}
