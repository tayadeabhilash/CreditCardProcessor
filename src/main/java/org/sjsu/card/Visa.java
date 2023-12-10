package org.sjsu.card;

public class Visa extends CreditCard {
    public Visa(String cardNumber) {
        super(cardNumber, "Visa");
    }

    public static boolean validateCard(String cardNumber) {
        if ((cardNumber.length() == 13 || cardNumber.length() == 16) && cardNumber.charAt(0) == '4') {
            return true;
        }
        return false;
    }
}
