package com.test.accounts.dto;

import com.test.accounts.model.Account;
import com.test.accounts.model.Cards;
import com.test.accounts.model.Loan;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerDetails {
    List<Account> accounts;
    List<Cards> cards;
    List<Loan> loans;

    public CustomerDetails(List<Account> accounts, List<Cards> cards, List<Loan> loans) {
        this.accounts = accounts;
        this.cards = cards;
        this.loans = loans;
    }

    public CustomerDetails() {
    }
}
