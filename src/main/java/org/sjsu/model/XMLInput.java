package org.sjsu.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "CARDS")
public class XMLInput {
    private List<CreditCardXmlInput> cards;

    @XmlElement(name = "CARD")
    public List<CreditCardXmlInput> getCards() {
        return cards;
    }

    public void setCards(List<CreditCardXmlInput> cards) {
        this.cards = cards;
    }
}

