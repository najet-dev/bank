package fr.najet.bank.entities;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;

@Entity
@Transactional
@DiscriminatorValue("P")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private Date date;
    private Long codeSource;
    private Long codeDestination;
    private double amount;
    @ManyToOne
    @JoinColumn(name="accountId")
    private Account account;
    public Payment (){}
    public Payment(Long id, Date date, Long codeSource, Long codeDestination, double amount, Account account) {
        this.id = id;
        this.date = date;
        this.codeSource = codeSource;
        this.codeDestination = codeDestination;
        this.amount = amount;
        this.account = account;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public Long getCodeSource() {
        return codeSource;
    }

    public void setCodeSource(Long codeSource) {
        this.codeSource = codeSource;
    }

    public Long getCodeDestination() {
        return codeDestination;
    }

    public void setCodeDestination(Long codeDestination) {
        this.codeDestination = codeDestination;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
