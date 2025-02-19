package com.test.cards.controller;

import com.test.cards.model.Cards;
import com.test.cards.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardController {

    @Autowired
    private CardRepository cardRepository;

    @PostMapping("/getCardDetails")
    public Cards getCardDetails(@RequestBody Integer customerId) {
        return cardRepository.findById(customerId).orElse(null);
        // Get card details
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
