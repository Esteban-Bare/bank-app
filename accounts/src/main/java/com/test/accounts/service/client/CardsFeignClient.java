package com.test.accounts.service.client;

import com.test.accounts.dto.CustomerIdDto;
import com.test.accounts.model.Cards;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("cards")
public interface CardsFeignClient {

    @RequestMapping(method = RequestMethod.POST, value = "/getAllCardsByCustomerId", consumes = "application/json")
    List<Cards> getAllCardsByCustomerId(CustomerIdDto customerId);
}
