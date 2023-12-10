package org.sjsu.reader;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.sjsu.card.CreditCard;
import org.sjsu.factory.CardFactory;
import org.sjsu.factory.CardFactoryImpl;
import org.sjsu.iterator.FileIterator;
import org.sjsu.iterator.XMLIterator;
import org.sjsu.model.CreditCardXmlInput;
import org.sjsu.model.CreditCardXmlOutput;
import org.sjsu.model.XMLInput;
import org.sjsu.model.XMLOutput;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;

public class XMLReader implements FileReader {
    XMLInput xmlInputFile;
    XMLOutput xmlOutput;

    public XMLReader() {
        this.xmlOutput = new XMLOutput();
        this.xmlOutput.setCards(new ArrayList<>());
    }

    @Override
    public void readInput(String inputFile) {
        try {
            ClassLoader classLoader = this.getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(inputFile);

            if (inputStream == null) {
                System.err.println("File not found: " + inputFile);
                return;
            }

            JAXBContext jaxbContext = JAXBContext.newInstance(XMLInput.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            this.xmlInputFile = (XMLInput) jaxbUnmarshaller.unmarshal(inputStream);
        } catch (JAXBException e) {
            System.err.println("Error reading XML File. Please verify xml: " + inputFile);
            return;
        }
    }

    @Override
    public void processCard(String outputFile) {

        try {
            FileIterator iterator = createIterator();
            while (!iterator.isEnd()) {
                String cardType = "Invalid: Not a possible card number";
                CreditCardXmlInput cardXmlInput = (CreditCardXmlInput) iterator.currentNode();
                String cardNumber = cardXmlInput.getCardNumber();
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
                CreditCardXmlOutput creditCardXmlOutput = new CreditCardXmlOutput();
                creditCardXmlOutput.setCardNumber(cardNumber);
                creditCardXmlOutput.setCardType(cardType);
                xmlOutput.getCards().add(creditCardXmlOutput);
                iterator.next();
            }
            this.writeOutput(outputFile);
        } catch (Exception e) {
            System.err.println("Error while processing xml file:" + e);
            return;
        }
    }

    @Override
    public void writeOutput(String outputFile) {
        try {
            File file = new File(outputFile);
            JAXBContext jaxbContext = JAXBContext.newInstance(XMLOutput.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(xmlOutput, file);
        } catch (JAXBException e) {
            System.err.println("Error writing XML File");
        }
    }

    @Override
    public FileIterator createIterator() {
        return new XMLIterator(xmlInputFile);
    }
}
