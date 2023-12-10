package org.sjsu.iterator;

import org.sjsu.model.XMLInput;

import java.util.List;

public class CSVIterator implements FileIterator {
    private int cursor;
    private int max;
    private List<String> input;

    public CSVIterator(List<String> input) {
        this.input = input;
        this.cursor = 0;
        this.max = input.size();
    }

    @Override
    public boolean isEnd() {
        return (max == cursor);
    }

    @Override
    public void next() {
        cursor++;
    }

    @Override
    public Object currentNode() {
        return input.get(cursor);
    }
}
