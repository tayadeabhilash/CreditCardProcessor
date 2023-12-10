package org.sjsu;

import org.sjsu.processor.FileProcessor;

public class Main {
    public static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessor();

        // Read input file name
        String inputFilename = args[0];

        // Read the output file name
        String outputFilename = args[1];

        fileProcessor.process(inputFilename, outputFilename);
    }
}