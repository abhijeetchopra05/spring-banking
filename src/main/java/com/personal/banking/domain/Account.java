package com.personal.banking.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "account")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public abstract class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
    @SequenceGenerator(name = "account_seq", sequenceName = "account_seq", initialValue = 1, allocationSize = 1, schema = "banking")
    private Long Id;

    @Column(name = "account_number")
    private Long accountNumber;


    @Column(name = "amount")
    private Double amount;

    @Column(name = "number_of_transaction")
    private Long numberOfTransaction;

    @Column(name = "number_of_debit")
    private Long numberOfDebit;

    @Column(name = "number_of_withdrawal")
    private Long numberOfWithdrawal;


    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    @ManyToOne
    private Branch branch;

    @ManyToOne
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
