package com.test.cards.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerIdDto {
    private int customerId;

    public CustomerIdDto() {
    }

    public CustomerIdDto(int customerId) {
        this.customerId = customerId;
    }

}
