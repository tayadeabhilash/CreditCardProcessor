package org.sjsu.card;

public class MasterCard extends CreditCard {
    public MasterCard(String cardNumber) {
        super(cardNumber, "MasterCard");
    }

    public static boolean validateCard(String cardNumber) {
        if ((cardNumber.charAt(0) == '5') && (cardNumber.charAt(1) == '1' || cardNumber.charAt(1) == '2'
                || cardNumber.charAt(1) == '3' || cardNumber.charAt(1) == '4' || cardNumber.charAt(1) == '5')) {
            return true;
        }
        return false;
    }
}
