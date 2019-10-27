package com.personal.banking.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "current_account")
public class CurrentAccount extends Account{

    @Column(name = "over_drawn_amount")
    private Double overDrawnAmount;


    public Double getOverDrawnAmount() {
        return overDrawnAmount;
    }

    public void setOverDrawnAmount(Double overDrawnAmount) {
        this.overDrawnAmount = overDrawnAmount;
    }
}
