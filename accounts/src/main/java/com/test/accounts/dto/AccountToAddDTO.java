package com.test.accounts.dto;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

public class AccountToAddDTO {
    private int customerId;
    private String accountType;
    private String branchAddress;
    private LocalDate createDt;

    public AccountToAddDTO() {
    }

    public AccountToAddDTO(int customerId, String accountType, String branchAddress, LocalDate createDt) {
        this.customerId = customerId;
        this.accountType = accountType;
        this.branchAddress = branchAddress;
        this.createDt = createDt;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public LocalDate getCreateDt() {
        return createDt;
    }

    public void setCreateDt(LocalDate createDt) {
        this.createDt = createDt;
    }
}
