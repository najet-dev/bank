package fr.najet.bank.dto;

import java.util.Date;

public class CurrentAccountDto {

    private String id;
    private Date createdAt;
    private double balance;
    private UserDto userDto;
    private double overDraft;

    public CurrentAccountDto() {
        super();
    }

    public CurrentAccountDto(String id, Date createdAt, double balance, UserDto userDto, double overDraft ) {
        this.id = id;
        this.createdAt = createdAt;
        this.balance = balance;
        this.userDto = userDto;
        this.overDraft = overDraft;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public double getOverDraft() {
        return overDraft;
    }

    public void setOverDraft(double overDraft) {
        this.overDraft = overDraft;
    }


}
