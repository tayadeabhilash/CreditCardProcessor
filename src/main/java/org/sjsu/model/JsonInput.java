package org.sjsu.model;

import java.util.List;

public class JsonInput {
    private List<CreditCardJsonInput> cards;

    public List<CreditCardJsonInput> getCards() {
        return cards;
    }

    public void setCards(List<CreditCardJsonInput> cards) {
        this.cards = cards;
    }
}
