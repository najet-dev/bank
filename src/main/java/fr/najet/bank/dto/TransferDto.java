package fr.najet.bank.dto;

public class TransferDto {

    private int accountSource;
    private int accountDestination;
    private double amount;

    public TransferDto() {
        super();
    }
    public TransferDto(int accountSource, int accountDestination, double amount) {

        this.accountSource = accountSource;
        this.accountDestination = accountDestination;
        this.amount = amount;
    }
    public int getAccountSource() {
        return accountSource;
    }

    public void setAccountSource(int accountSource) {
        this.accountSource = accountSource;
    }

    public int getAccountDestination() {
        return accountDestination;
    }
    public void setAccountDestination(int accountDestination) {
        this.accountDestination = accountDestination;
    }
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}


