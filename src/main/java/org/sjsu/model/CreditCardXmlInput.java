package org.sjsu.model;

import jakarta.xml.bind.annotation.XmlElement;

public class CreditCardXmlInput {
    private String cardNumber;
    private String expirationDate;
    private String cardHolderName;

    @XmlElement(name = "CARD_NUMBER")
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @XmlElement(name = "EXPIRATION_DATE")
    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @XmlElement(name = "CARD_HOLDER_NAME")
    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }
}
