package fr.najet.bank.dto;

import fr.najet.bank.entities.Account;
import fr.najet.bank.entities.Client;
import fr.najet.bank.entities.Operation;
import fr.najet.bank.enums.AccountTypeEnum;

import java.util.Date;
import java.util.List;

public class AccountDto {
    public String id;
    public AccountTypeEnum type;
    public Date dateCreation;
    public double balance;
    public Client client;
    public List<Operation> operations;

    public AccountDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AccountTypeEnum getType() {
        return type;
    }

    public void setType(AccountTypeEnum type) {
        this.type = type;
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

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
    public static Account addAccount(AccountDto accountDto) {
        Account account = new Account(accountDto.getType(), accountDto.getDateCreation(), accountDto.getBalance(), accountDto.getClient(), accountDto.getOperations());
        return account;
    }


}
