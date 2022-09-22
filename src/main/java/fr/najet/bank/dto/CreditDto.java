package fr.najet.bank.dto;

public class CreditDto {
    private int accountId;
    private double amount;
    private String description;

    public CreditDto() {
        super();
    }

    public CreditDto(int accountId, double amount, String description) {
        this.accountId = accountId;
        this.amount = amount;
        this.description = description;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
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

}


