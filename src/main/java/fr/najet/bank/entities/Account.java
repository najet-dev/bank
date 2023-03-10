package fr.najet.bank.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Transactional
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "accounts")
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected int id;
  protected String name;
  protected String type;
  protected Date createdAt = new Date();
  protected double balance;

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "userId")
  public User user;
  @JsonSerialize(using = AccountOperationSerializer.class)
  @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
  public List<AccountOperation> accountOperations = new ArrayList<>();

  public Account() {
    super();
  }

  public Account(String type, String name, double balance, User user) {
    this.type = type;
    this.name = name;
    this.balance = balance;
    this.user = user;
  }

  public Account(String type, String name, int balance, int id) {
    this.type = type;
    this.name = name;
    this.balance = balance;
    this.id = id;
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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


  public List<AccountOperation> getAccountOperations() {
    return accountOperations;
  }

  public void setAccountOperations(List<AccountOperation> accountOperations) {
    this.accountOperations = accountOperations;
  }

  public void debit(int id, double amount) {
    balance-=amount;
    System.out.println(id + "?? d??biter" + amount);
  }
  public void credit(int id, double amount) {
    balance+=amount;
    System.out.println(id + "?? cr??diter" + amount);
  }
}
