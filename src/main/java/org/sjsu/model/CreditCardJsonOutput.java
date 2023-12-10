package org.sjsu.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreditCardJsonOutput {
    private String cardNumber;
    private String cardType;

    @JsonProperty("cardNumber")
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @JsonProperty("cardType")
    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
}
