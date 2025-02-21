package com.test.accounts.service.client;

import com.test.accounts.dto.CustomerIdDto;
import com.test.accounts.model.Loan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("loans")
public interface LoansFeignClient {

    @RequestMapping(method = RequestMethod.POST, value = "/get-loan-by-customer", consumes = "application/json")
    List<Loan> getLoanByCustomer(CustomerIdDto customerId);
}
