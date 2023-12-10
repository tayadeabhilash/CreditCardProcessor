package org.sjsu.iterator;

import org.sjsu.model.JsonInput;

import java.util.List;

public class JSONIterator implements FileIterator {
    private int cursor;
    private int max;
    private JsonInput input;

    public JSONIterator(JsonInput input) {
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
