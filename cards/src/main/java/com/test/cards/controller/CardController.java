package com.test.cards.controller;

import com.test.cards.model.CardIdDto;
import com.test.cards.model.Cards;
import com.test.cards.model.CustomerIdDto;
import com.test.cards.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardController {

    @Autowired
    private CardRepository cardRepository;

    @PostMapping("/getCardDetails")
    public Cards getCardDetails(@RequestBody CardIdDto cardId) {
        return cardRepository.findById(cardId.getCardId()).orElse(null);
        // Get card details
    }

    @PostMapping("/getAllCardsByCustomerId")
    public List<Cards> getAllCardsByCustomerId(@RequestBody CustomerIdDto customerIdDto) {
        return cardRepository.findAllByCustomerId(customerIdDto.getCustomerId());
        // Get all cards by customer ID
    }


    @GetMapping("/getAllCards")
    public List<Cards> getAllCards() {
        return cardRepository.findAll();
        // Get all cards
    }

    @PostMapping("/addCard")
    public void addCard(@RequestBody Cards card) {
        cardRepository.save(card);
        // Add a new card
        //
    }

    @PutMapping("/updateCard")
    public void updateCard(@RequestBody Cards card) {
        cardRepository.save(card);
        // The card body needs the cardId to update
    }

    @DeleteMapping("/deleteCard/{cardId}")
    public void deleteCard(@PathVariable int cardId) {
        cardRepository.deleteById(cardId);
    }
}
