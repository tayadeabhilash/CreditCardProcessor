package org.sjsu.model;

import java.util.List;

public class JsonOutput {
    private List<CreditCardJsonOutput> cards;

    public List<CreditCardJsonOutput> getCards() {
        return cards;
    }

    public void setCards(List<CreditCardJsonOutput> cards) {
        this.cards = cards;
    }
}
