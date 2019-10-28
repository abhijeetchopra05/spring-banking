package com.personal.banking.dto;

public class SavingAccountDTO extends AccountDTO {

    private Double minimumBalance;

    private Long minimumNumberOfDebit;

    private Double rateOfInterest;

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

    @Override
    public Long getNumberOfDebit() {
        return numberOfDebit;
    }

    @Override
    public void setNumberOfDebit(Long numberOfDebit) {
        this.numberOfDebit = numberOfDebit;
    }
}
