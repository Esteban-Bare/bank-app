package com.test.accounts.controller;

import com.test.accounts.dto.AccountToAddDTO;
import com.test.accounts.dto.AccountDTO;
import com.test.accounts.model.Account;
import com.test.accounts.model.Customer;
import com.test.accounts.repository.AccountRepository;
import com.test.accounts.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/my-account")
    public Account getAccountDetails(@RequestBody Integer customerId) {
        return accountRepository.findById(customerId).orElse(null);
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
}
