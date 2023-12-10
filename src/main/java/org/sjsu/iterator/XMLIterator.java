package org.sjsu.iterator;

import org.sjsu.model.XMLInput;

import java.util.List;

public class XMLIterator implements FileIterator {
    private int cursor;
    private int max;
    private XMLInput input;

    public XMLIterator(XMLInput input) {
        this.input = input;
        this.cursor = 0;
        this.max = input.getCards().size();
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
        return input.getCards().get(cursor);
    }
}
