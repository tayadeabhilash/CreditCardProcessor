package org.sjsu.factory;

import org.sjsu.card.AmericanExpress;
import org.sjsu.card.CreditCard;
import org.sjsu.card.Discover;
import org.sjsu.card.MasterCard;
import org.sjsu.card.Visa;

public class CardFactoryImpl implements CardFactory {
    @Override
    public CreditCard createCreditCard(String cardNumber) {
        if(!cardNumber.isEmpty()) {
            if (MasterCard.validateCard(cardNumber)) {
                return new MasterCard(cardNumber);
            } else if (Visa.validateCard(cardNumber)) {
                return new Visa(cardNumber);
            } else if (AmericanExpress.validateCard(cardNumber)) {
                return new AmericanExpress(cardNumber);
            } else if (Discover.validateCard(cardNumber)) {
                return new Discover(cardNumber);
            }
        }
        return null;
    }
}
