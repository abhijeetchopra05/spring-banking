package com.personal.banking.dto;

public class CurrentAccountDTO extends AccountDTO {

    private Double overDrawnAmount;

    public Double getOverDrawnAmount() {
        return overDrawnAmount;
    }

    public void setOverDrawnAmount(Double overDrawnAmount) {
        this.overDrawnAmount = overDrawnAmount;
    }
}
