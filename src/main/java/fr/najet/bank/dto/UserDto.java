package fr.najet.bank.dto;

import fr.najet.bank.entities.Account;
import fr.najet.bank.entities.User;

import java.util.List;

public class UserDto {
    public int id;
    public  String lastName;
    public String firstName;
    public  String email;
    public  String userName;
    public int role;
    public  String password;

    public List<Account> accounts;



    public UserDto(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }




    public static User addUser(UserDto userDto) {
        User user = new User(userDto.getId(), userDto.getLastName(), userDto.getFirstName(), userDto.getEmail(), userDto.getUserName(),userDto.getRole(), userDto.getPassword(), userDto.getAccounts());
        return user;
    }
}
