package com.crud.crud.dto;

public class BankAccountDTO extends BaseDTO<Long> {

    private String bankName;
    private String accountNumber;
    private String accountType;
    private Double balance;
    private String currency;
    
    public BankAccountDTO() {}
    
    public BankAccountDTO(String accountType, String bankName, String accountNumber, Double balance, String currency) {
        this.accountType = accountType;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.currency = currency;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
