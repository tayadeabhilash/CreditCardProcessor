package org.sjsu.reader;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.sjsu.card.CreditCard;
import org.sjsu.factory.CardFactory;
import org.sjsu.factory.CardFactoryImpl;
import org.sjsu.iterator.FileIterator;
import org.sjsu.iterator.JSONIterator;
import org.sjsu.model.CreditCardJsonInput;
import org.sjsu.model.CreditCardJsonOutput;
import org.sjsu.model.JsonInput;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class JSONReader implements FileReader {
    JsonInput jsonInput;
    ArrayList<CreditCardJsonOutput> jsonOutput;
    ObjectMapper objectMapper;

    public JSONReader() {
        this.jsonInput = new JsonInput();
        this.jsonOutput = new ArrayList<>();
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public void readInput(String inputFile) {
        try (InputStream in = getClass().getClassLoader().getResourceAsStream(inputFile)) {
            CreditCardJsonInput[] inputs = objectMapper.readValue(in, CreditCardJsonInput[].class);
            jsonInput.setCards(Arrays.asList(inputs));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void processCard(String outputFile) {
        FileIterator iterator = createIterator();
        while (!iterator.isEnd()) {
            String cardType = "Invalid: Not a possible card number";
            CreditCardJsonInput creditCardJsonInput = (CreditCardJsonInput) iterator.currentNode();
            String cardNumber = creditCardJsonInput.getCardNumber();
            CreditCardJsonOutput creditCardJsonOutput = new CreditCardJsonOutput();
            creditCardJsonOutput.setCardNumber(cardNumber);
            CreditCard card = null;
            String validCard = CreditCard.isValidCreditCardNumber(cardNumber);
            if (validCard.equals("VALID")) {
                CardFactory cardFactory = new CardFactoryImpl();
                card = cardFactory.createCreditCard(cardNumber);
            } else {
                cardType = validCard;
            }
            if (card != null) {
                cardType = card.getCardType();
            }
            creditCardJsonOutput.setCardType(cardType);
            jsonOutput.add(creditCardJsonOutput);
            iterator.next();
        }
        this.writeOutput(outputFile);
    }

    @Override
    public void writeOutput(String outputFile) {
        try {
            objectMapper.writeValue(new File(outputFile), jsonOutput);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public FileIterator createIterator() {
        return new JSONIterator(jsonInput);
    }
}
