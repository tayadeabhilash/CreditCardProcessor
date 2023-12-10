package org.sjsu.iterator;

import org.sjsu.model.CreditCardJsonInput;
import org.sjsu.model.CreditCardXmlInput;

public interface FileIterator {
    boolean isEnd();
    void next();
    Object currentNode();
}
