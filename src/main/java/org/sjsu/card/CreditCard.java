package org.sjsu.card;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class CreditCard {
    String cardNumber;
    String cardType;
    CreditCard(String cardNumber, String cardType) {
        this.cardNumber = cardNumber;
        this.cardType = cardType;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public static String isValidCreditCardNumber(String cardNumber) {
        if (cardNumber == null || cardNumber.trim().isEmpty()) {
            return "Invalid: empty/null card number";
        }

        if (cardNumber.length() > 19) {
            return "Invalid: more than 19 digits";
        }

        String regex = "\\d+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cardNumber);

        if(!matcher.matches())
            return "Invalid: non numeric characters";

        return "VALID";
    }
}
