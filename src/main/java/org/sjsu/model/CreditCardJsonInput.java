package org.sjsu.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreditCardJsonInput {
    private String cardNumber;
    private String expirationDate;
    private String cardHolderName;

    @JsonProperty("cardNumber")
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @JsonProperty("expirationDate")
    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @JsonProperty("cardHolderName")
    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }
}
