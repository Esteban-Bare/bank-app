package com.test.loans.controller;

import com.test.loans.Repository.LoanRepository;
import com.test.loans.model.CustomerDTO;
import com.test.loans.model.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoanController {

    @Autowired
    private LoanRepository loanRepository;

    @PostMapping("/add-loan")
    public Loan addLoan(@RequestBody Loan loan) {
        return loanRepository.save(loan);
    }

    @PostMapping("/get-loan/{loanNumber}")
    public Loan getLoan(@PathVariable int loanNumber) {
        return loanRepository.findById(loanNumber).orElse(null);
    }

    @PostMapping("/all-loans")
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    @PostMapping("/get-loan-by-customer-by-start-date")
    public List<Loan> getLoanByCustomerByStartDate(@RequestBody CustomerDTO customerDTO) {
        List<Loan> loans = loanRepository.findAll();
        return loans.stream().filter(loan -> loan.getCustomerId() == customerDTO.getCustomerId()).sorted((loan1, loan2) -> loan2.getStartDt().compareTo(loan1.getStartDt())).toList();
    }

    @PostMapping("/get-loan-by-customer")
    public List<Loan> getLoanByCustomer(@RequestBody CustomerDTO customerDTO) {
        List<Loan> loans = loanRepository.findAll();
        return loans.stream().filter(loan -> loan.getCustomerId() == customerDTO.getCustomerId()).toList();
    }


}
