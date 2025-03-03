package com.crud.crud.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction extends BaseEntity<Long> {
    private String transactionType;
    private Double amount;
    private String description;
    private String category;
    private Date transactionDate;
    
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private BankAccount bankAccount;
}