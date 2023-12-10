package org.sjsu.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;


@XmlRootElement(name = "CARDS")
public class XMLOutput {
    private List<CreditCardXmlOutput> cards;

    @XmlElement(name = "CARD")
    public List<CreditCardXmlOutput> getCards() {
        return cards;
    }

    public void setCards(List<CreditCardXmlOutput> cards) {
        this.cards = cards;
    }
}

