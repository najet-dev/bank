package fr.najet.bank.dto;

import fr.najet.bank.entities.AccountOperation;
import fr.najet.bank.entities.User;

import java.util.Date;
import java.util.List;

public class AccountDto {
    protected int id;

    public String type;

    protected Date createdAt;
    protected double balance;

    protected User user;
    protected   String lastName;
    protected String firstName;
    protected  String email;
    protected  String userName;
    protected int role;
    protected String password;
    public List<AccountOperation> accountOperations;

    protected double overDraft;

    protected double interestRate;

    public AccountDto(){}

    public AccountDto(String type, Date createdAt, double balance, User user, String lastName, String firstName, String email, String userName, int role, String password, List<AccountOperation> accountOperations, double overDraft, double interestRate)  {
        this.type = type;
        this.createdAt = createdAt;
        this.balance = balance;
        this.user = user;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.userName = userName;
        this.role = role;
        this.password = password;
        this.accountOperations = accountOperations;
        this.overDraft = overDraft;
        this.interestRate = interestRate;
    }
    public AccountDto(int id, String type, Date createdAt, double balance, User user, String lastName, String firstName, String email, String userName, int role, String password, List<AccountOperation> accountOperations, double overDraft, double interestRate)  {
        this.id = id;
        this.createdAt = createdAt;
        this.balance = balance;
        this.user = user;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.userName = userName;
        this.role = role;
        this.password = password;
        this.accountOperations = accountOperations;
        this.overDraft = overDraft;
        this.interestRate = interestRate;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        this.user = user;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<AccountOperation> getAccountOperations() {
        return accountOperations;
    }

    public void setAccountOperations(List<AccountOperation> accountOperations) {
        this.accountOperations = accountOperations;
    }
    public double getOverDraft() {
        return overDraft;
    }

    public void setOverDraft(double overDraft) {
        this.overDraft = overDraft;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

   /* public static Account updateAccount(AccountDto accountDto) {
        Account account = new CurrentAccount(accountDto.getId(), accountDto.getType(), accountDto.getCreatedAt(), accountDto.getBalance(), accountDto.getUser(), accountDto.getLastName(), accountDto.getFirstName(), accountDto.getEmail(), accountDto.getUserName(), accountDto.getRole(), accountDto.getPassword(), accountDto.getAccountOperations(), accountDto.getOverDraft());

        return account;
    }*/

}



