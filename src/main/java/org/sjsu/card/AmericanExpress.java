package org.sjsu.card;

public class AmericanExpress extends CreditCard {
    public AmericanExpress(String cardNumber) {
        super(cardNumber, "American Express");
    }

    public static boolean validateCard(String cardNumber) {
        if ((cardNumber.charAt(0) == '3') && (cardNumber.charAt(1) == '4' || cardNumber.charAt(1) == '7') &&
                cardNumber.length() == 15) {
            return true;
        }
        return false;
    }
}
