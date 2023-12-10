package org.sjsu.factory;

import org.sjsu.card.CreditCard;

public interface CardFactory {
    CreditCard createCreditCard(String cardNumber);
}
