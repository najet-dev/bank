package fr.najet.bank.dto;

import fr.najet.bank.entities.AccountOperation;
import fr.najet.bank.enums.OperationTypeEnum;
import java.util.Date;

public class AccountOperationDto {
  public int id;
  public Date createdAt = new Date();
  public int targetedAccount;
  public OperationTypeEnum type;

  public double amount;
  public String description;

  //public Account account;


  public AccountOperationDto(int id, Date createdAt, int targetedAccount, OperationTypeEnum type,
                             double amount, String description) {
    this.id = id;
    this.createdAt = createdAt;
    this.targetedAccount = targetedAccount;
    this.type = type;
    this.amount = amount;
    this.description = description;
  }

  public static AccountOperationDto fromAccountOperation(AccountOperation original) {
    return new AccountOperationDto(original.getId(), original.getCreatedAt(),
        original.getAccount().getId(),
        original.getType(),
        original.getAmount(),
        original.getDescription()
    );
  }

  public AccountOperationDto() {
    super();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public int getTargetedAccount() {
    return targetedAccount;
  }

  public void setTargetedAccount(int targetedAccount) {
    this.targetedAccount = targetedAccount;
  }

  public OperationTypeEnum getType() {
    return type;
  }

  public void setType(OperationTypeEnum type) {
    this.type = type;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  /*public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }
    /*public AccountOperationDto fromAccountOperation(AccountOperation accountOperation) {
        AccountOperationDto accountOperationDto = new AccountOperationDto();
        BeanUtils.copyProperties(accountOperation, accountOperationDto);
        return accountOperationDto;
    }*/
}
