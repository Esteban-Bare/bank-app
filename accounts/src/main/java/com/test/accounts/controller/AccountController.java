package com.test.accounts.controller;

import com.test.accounts.dto.AccountToAddDTO;
import com.test.accounts.dto.AccountDTO;
import com.test.accounts.dto.CustomerIdDto;
import com.test.accounts.model.Account;
import com.test.accounts.model.Cards;
import com.test.accounts.model.Customer;
import com.test.accounts.dto.CustomerDetails;
import com.test.accounts.model.Loan;
import com.test.accounts.repository.AccountRepository;
import com.test.accounts.repository.CustomerRepository;
import com.test.accounts.service.client.CardsFeignClient;
import com.test.accounts.service.client.LoansFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CardsFeignClient cardsFeignClient;
    @Autowired
    private LoansFeignClient loansFeignClient;

    @PostMapping("/my-account")
    public List<Account> getAccountDetails(@RequestBody CustomerIdDto customerId) {
        return accountRepository.findAllByCustomer_CustomerId(customerId.getCustomerId());
    }

    @PostMapping("/all-accounts")
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @PostMapping("/add-account")
    public Account addAccount(@RequestBody AccountToAddDTO account) {
        Customer customer = customerRepository.findById(account.getCustomerId()).orElse(null);
        return accountRepository.save(new Account(customer, account.getAccountType(), account.getBranchAddress(), account.getCreateDt()));
    }

    @DeleteMapping("/delete-account/{accountId}")
    public void deleteAccount(@PathVariable Integer accountId) {
        accountRepository.deleteById(accountId);
    }

    @PutMapping("/update-account")
    public Account updateAccount(@RequestBody AccountDTO account) {
        Account accountToUpdate = accountRepository.findById(account.getAccountNumber()).orElse(null);
        if (accountToUpdate != null) {
            accountToUpdate.setAccountType(account.getAccountType());
            accountToUpdate.setBranchAddress(account.getBranchAddress());
            accountToUpdate.setCreateDt(account.getCreateDt());
            return accountRepository.save(accountToUpdate);
        }
        return null;
    }

    @PostMapping("/get-customer-details")
    public CustomerDetails getCustomerDetails(@RequestBody CustomerIdDto customerId) {
        List<Account> accounts = accountRepository.findAllByCustomer_CustomerId(customerId.getCustomerId());
        CustomerIdDto customerIdDto = new CustomerIdDto(customerId.getCustomerId());
        List<Cards> cards = cardsFeignClient.getAllCardsByCustomerId(customerIdDto);
        List<Loan> loans = loansFeignClient.getLoanByCustomer(customerIdDto);
        return new CustomerDetails(accounts, cards, loans);
    }
}
