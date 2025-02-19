package com.test.accounts.dto;

import java.time.LocalDate;
import java.util.List;

public class CustomerToUpdateDto {
    private int customerId;
    private String name;
    private String email;
    private String mobileNumber;
    private LocalDate createDt;

    public CustomerToUpdateDto() {
    }

    public CustomerToUpdateDto(int customerId, String name, String email, String mobileNumber, LocalDate createDt) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.createDt = createDt;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public LocalDate getCreateDt() {
        return createDt;
    }

    public void setCreateDt(LocalDate createDt) {
        this.createDt = createDt;
    }
}
