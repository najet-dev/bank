package fr.najet.bank.dto;

public class DebitDto {

    private int id;
    private double amount;
    private String description;

    public DebitDto() {
        super();
    }

    public DebitDto(int id, double amount, String description) {

        this.id = id;
        this.amount = amount;
        this.description = description;
    }

    public int getAccountId() {
        return id;
    }

    public void setAccountId(int accountId) {
        this.id = id;
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
