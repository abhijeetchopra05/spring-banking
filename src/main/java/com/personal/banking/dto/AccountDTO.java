package com.personal.banking.dto;

import com.personal.banking.domain.Branch;
import com.personal.banking.domain.User;

import java.util.Date;

public class AccountDTO {

    private Long Id;

    private Long accountNumber;


    private Double amount;

    private Long numberOfTransaction;

    private Long numberOfDebit;

    private Long numberOfWithdrawal;

    private Date createdAt;

    private Date updatedAt;

    private Branch branch;

    private User user;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getNumberOfTransaction() {
        return numberOfTransaction;
    }

    public void setNumberOfTransaction(Long numberOfTransaction) {
        this.numberOfTransaction = numberOfTransaction;
    }

    public Long getNumberOfDebit() {
        return numberOfDebit;
    }

    public void setNumberOfDebit(Long numberOfDebit) {
        this.numberOfDebit = numberOfDebit;
    }

    public Long getNumberOfWithdrawal() {
        return numberOfWithdrawal;
    }

    public void setNumberOfWithdrawal(Long numberOfWithdrawal) {
        this.numberOfWithdrawal = numberOfWithdrawal;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
