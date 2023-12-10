package org.sjsu.card;

public class Discover extends CreditCard {
    public Discover(String cardNumber) {
        super(cardNumber, "Discover");
    }

    public static boolean validateCard(String cardNumber) {
        if ((cardNumber.startsWith("6011")) && cardNumber.length() == 16) {
            return true;
        }
        return false;
    }
}
