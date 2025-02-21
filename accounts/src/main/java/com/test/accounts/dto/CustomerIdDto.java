package com.test.accounts.dto;

public class CustomerIdDto {
    private int customerId;

    public CustomerIdDto(int customerId) {
        this.customerId = customerId;
    }

    public CustomerIdDto() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
