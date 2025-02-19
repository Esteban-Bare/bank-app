package com.test.accounts.controller;

import com.test.accounts.dto.AccountDTO;
import com.test.accounts.dto.CustomerToUpdateDto;
import com.test.accounts.dto.CustomersDTO;
import com.test.accounts.model.Account;
import com.test.accounts.model.Customer;
import com.test.accounts.repository.AccountRepository;
import com.test.accounts.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/customer")
    public Customer getAccountDetails(@RequestBody Integer customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    @PostMapping("/all-customers")
    public List<CustomersDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(customer -> {
            List<Account> test = accountRepository.findAllByCustomer_CustomerId(customer.getCustomerId());
            return new CustomersDTO(customer.getCustomerId(), customer.getName(), customer.getEmail(), customer.getMobileNumber(), customer.getCreateDt(), test.stream().map(accounts -> new AccountDTO(accounts.getAccountNumber(),accounts.getAccountType(),accounts.getBranchAddress(),accounts.getCreateDt())).collect(Collectors.toList()));
        }).toList();
    }

    @PostMapping("/add-customer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @PutMapping("/update-customer")
    public Customer updateCustomer(@RequestBody CustomerToUpdateDto customer) {
        Customer customerToUpdate = customerRepository.findById(customer.getCustomerId()).orElse(null);
        if (customerToUpdate != null) {
            customerToUpdate.setName(customer.getName());
            customerToUpdate.setEmail(customer.getEmail());
            customerToUpdate.setMobileNumber(customer.getMobileNumber());
            return customerRepository.save(customerToUpdate);
        }
        return null;
    }

    @DeleteMapping("/delete-customer/{customerId}")
    public void deleteCustomer(@PathVariable Integer customerId) {
        customerRepository.deleteById(customerId);
    }
}
