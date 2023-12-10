package org.sjsu.reader;

import org.sjsu.iterator.FileIterator;

public interface FileReader {
    void readInput(String inputFile);
    void processCard(String outputFile);
    void writeOutput(String outputFile);
    FileIterator createIterator();
}
