package fr.najet.bank.dto;

import com.fasterxml.jackson.annotation.JsonValue;
import fr.najet.bank.entities.Account;
import java.util.ArrayList;
import java.util.List;

public class UserDto {

  public int id;

  public String lastName;

  public String firstName;

  public String userName;

  public String role;

  public String password;

  public List<Account> accounts = new ArrayList<>();

  public UserDto() {
  }
  public UserDto(String lastName, String firstName, List accounts) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.accounts = accounts;
  }

  public UserDto(String lastName, String firstName, String userName, String role,
                 String password) {

    this.lastName = lastName;
    this.firstName = firstName;
    this.userName = userName;
    this.role = role;
    this.password = password;
  }
  @JsonValue
  public  int getId() {
    return id;
  }

  public void setId( int id) {
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

  public String getPassword() {
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

}
