package com.test.cards.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CardIdDto {
    private int cardId;

    public CardIdDto() {
    }

    public CardIdDto(int cardId) {
        this.cardId = cardId;
    }

}
