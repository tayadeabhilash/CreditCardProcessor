package org.sjsu.model;

import jakarta.xml.bind.annotation.XmlElement;

public class CreditCardXmlOutput {
    private String cardNumber;
    private String cardType;

    @XmlElement(name = "CARD_NUMBER")
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @XmlElement(name = "CARD_TYPE")
    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
}
