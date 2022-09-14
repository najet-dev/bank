package fr.najet.bank.dto;

import fr.najet.bank.entities.Account;
import fr.najet.bank.enums.AccountTypeEnum;

import java.util.List;

public class ClientAddCompteDto {
    public int idClient;
    public int idAccount;
    protected AccountTypeEnum type;

    public List<Account> accounts;


    public ClientAddCompteDto() {
    }

    public ClientAddCompteDto(int idClient, int idAccount, AccountTypeEnum type, List<Account> accounts) {
        this.idClient = idClient;
        this.idAccount = idAccount;
        this.type = type;
        this.accounts = accounts;

    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public AccountTypeEnum getType() {
        return type;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public void setType(AccountTypeEnum type) {
        this.type = type;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
