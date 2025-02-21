package com.test.cards.repository;

import com.test.cards.model.Cards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Cards, Integer> {
    List<Cards> findAllByCustomerId(int customerId);
}
