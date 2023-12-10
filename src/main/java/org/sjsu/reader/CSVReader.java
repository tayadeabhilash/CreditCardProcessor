package org.sjsu.reader;

import org.sjsu.card.CreditCard;
import org.sjsu.factory.CardFactory;
import org.sjsu.factory.CardFactoryImpl;
import org.sjsu.iterator.CSVIterator;
import org.sjsu.iterator.FileIterator;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader implements FileReader {
    private List<String> inputLines;
    private List<String> outputLines;

    public CSVReader() {
        inputLines = new ArrayList<>();
        outputLines = new ArrayList<>();
    }

    @Override
    public void readInput(String inputFile) {
        try (InputStream ioStream = this.getClass().getClassLoader().getResourceAsStream(inputFile)) {
            try (InputStreamReader isr = new InputStreamReader(ioStream);
                 BufferedReader br = new BufferedReader(isr);) {
                String line;
                while ((line = br.readLine()) != null) {
                    inputLines.add(line);
                }
                ioStream.close();
            }
        } catch (IOException e) {
            System.err.println("Error reading csv file");
        }
        if (inputLines.get(0).toLowerCase().startsWith("card")) {
            inputLines.remove(0);
        }
    }

    @Override
    public void processCard(String outputFile) {
        FileIterator iterator = createIterator();
        outputLines.add("CardNumber,CardType");
        String card;
        String output;

        while (!iterator.isEnd()) {
            card = (String) iterator.currentNode();

            if (card.equals("")) {
                outputLines.add("null,Invalid");
                iterator.next();
                continue;
            }

            output = this.processLine(card);

            outputLines.add(output);
            iterator.next();
        }

        this.writeOutput(outputFile);
    }

    @Override
    public void writeOutput(String outputFile) {
        try {
            FileWriter fileWriter = new FileWriter(outputFile);
            FileIterator iterator = new CSVIterator(outputLines);

            while (!iterator.isEnd()) {
                fileWriter.write(iterator.currentNode() + "\n");
                iterator.next();
            }
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Error writing CSV file");
        }
    }

    @Override
    public FileIterator createIterator() {
        return new CSVIterator(inputLines);
    }

    private String processLine(String line) {
        String cardNumber = "";
        String cardType = "Invalid: Not a possible card number";
        CreditCard card;
        cardNumber = line.split(",")[0];
        String validCard = CreditCard.isValidCreditCardNumber(cardNumber);
        if (validCard.equals("VALID")) {
            CardFactory cardFactory = new CardFactoryImpl();

            card = cardFactory.createCreditCard(cardNumber);

            if (card != null) {
                cardType = card.getCardType();
            }
        } else {
            cardType = validCard;
        }
        return (cardNumber + "," + cardType);
    }
}
