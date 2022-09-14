package fr.najet.bank.dto;

import fr.najet.bank.entities.Account;
import fr.najet.bank.entities.Client;

import java.util.List;

public class ClientDto {
    public int id;
    protected String userName;
    protected String password;
    protected int role;
    protected String lastName;
    protected String firstName;
    protected String email;
    protected List<Account> accounts;

    public ClientDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
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

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public static Client addClient(ClientDto clientDto) {
        Client client = new Client(clientDto.getUserName(), clientDto.getPassword() ,clientDto.getRole(),clientDto.getLastName(), clientDto.getFirstName(), clientDto.getEmail(), clientDto.getAccounts());
        return client;
    }

}
