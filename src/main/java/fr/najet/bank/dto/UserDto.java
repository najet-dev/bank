package fr.najet.bank.dto;

import fr.najet.bank.entities.Account;

import java.util.ArrayList;
import java.util.List;

public class UserDto {
    public int id;
    public  String lastName;
    public String firstName;
    public  String email;
    public  String userName;
    public String role;
    public  String password;

   public List<Account> accounts = new ArrayList<>();

    public UserDto(){}

    public UserDto( String lastName, String firstName, String email, String userName, String role, String password) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.userName = userName;
        this.role = role;
        this.password = password;
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


  /*  public static User updateUser(UserDto userDto) {
        User user = new User(userDto.getLastName(), userDto.getFirstName(), userDto.getEmail(), userDto.getUserName(),userDto.getRole(), userDto.getPassword());
        return user;
    }*/
}
