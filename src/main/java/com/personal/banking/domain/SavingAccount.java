package com.personal.banking.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "saving_account")
public class SavingAccount extends Account{


    @Column(name = "minimum_balance")
    private Double minimumBalance;

    @Column(name = "minimum_number_of_debit")
    private Long minimumNumberOfDebit;

    @Column(name = "rate_of_interest")
    private Double rateOfInterest;

    @Column(name = "number_of_debit")
    private Long numberOfDebit;


    public Double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(Double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public Long getMinimumNumberOfDebit() {
        return minimumNumberOfDebit;
    }

    public void setMinimumNumberOfDebit(Long minimumNumberOfDebit) {
        this.minimumNumberOfDebit = minimumNumberOfDebit;
    }

    public Double getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(Double rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public Long getNumberOfDebit() {
        return numberOfDebit;
    }

    public void setNumberOfDebit(Long numberOfDebit) {
        this.numberOfDebit = numberOfDebit;
    }
}
