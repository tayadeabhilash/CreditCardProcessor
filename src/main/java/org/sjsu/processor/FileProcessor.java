package org.sjsu.processor;

import org.sjsu.reader.CSVReader;
import org.sjsu.reader.FileReader;
import org.sjsu.reader.JSONReader;
import org.sjsu.reader.XMLReader;

import java.io.File;

public class FileProcessor {

    public void process(String inputFilename, String outputFilename) {
        String inputExtension = inputFilename.substring(inputFilename.lastIndexOf(".") + 1).toLowerCase();
        String outputExtension = outputFilename.substring(outputFilename.lastIndexOf(".") + 1).toLowerCase();

        if (!inputExtension.equals(outputExtension)) {
            System.err.println("Please enter the same type of files.");
            return;
        }

        try {
            FileReader fileReader;
            if (inputFilename.endsWith(".csv")) {
                fileReader = new CSVReader();
            } else if (inputFilename.endsWith(".json")) {
                fileReader = new JSONReader();
            } else if (inputFilename.endsWith(".xml")) {
                fileReader = new XMLReader();
            } else {
                System.err.print(inputExtension + " is not a valid file type");
                return;
            }

            fileReader.readInput(inputFilename);

            File file = new File(outputFilename);
            file.createNewFile();

            fileReader.processCard(outputFilename);
        } catch (Exception e) {
            System.out.print("Error while Parsing File:" + e);
        }
    }
}
