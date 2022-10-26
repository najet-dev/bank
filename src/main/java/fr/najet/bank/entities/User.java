package fr.najet.bank.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "users",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
    })
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private int code;
  private String lastName;
  private String firstName;
  private String username;
  private String password;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_roles",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  @JsonSerialize(using = UserAccountSerializer.class)
  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
  private List<Account> accounts = new ArrayList<>();

  public User(int code, String lastName, String firstName, String password, String username) {
    this.code = code;
    this.lastName = lastName;
    this.firstName = firstName;
    this.username = username;
    this.password = password;
  }

  public User() {

  }



  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public User(int id, String lastName, String firstName, String username,
              String password, List<Account> accounts) {
    this.id = id;
    this.lastName = lastName;
    this.firstName = firstName;
    this.username = username;
    this.password = password;
    this.accounts = accounts;
  }

  public User(String username, String password) {
    this.username = username;
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

  public String getUsername() {
    return username;
  }

  public void setUsername(String userName) {
    this.username = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  public List<Account> getAccounts() {
    return accounts;
  }

  public void setAccounts(List<Account> accounts) {
    this.accounts = accounts;
  }

}
