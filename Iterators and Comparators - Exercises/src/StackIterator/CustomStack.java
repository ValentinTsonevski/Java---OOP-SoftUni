package StackIterator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomStack implements Iterable<Integer>{
    private ArrayDeque<Integer> stack ;
    private int currentElement;
    private int previousElement;

    public CustomStack(int currentElement, int previousElement) {
        this.currentElement = currentElement;
        this.previousElement = previousElement;
        this.stack = new ArrayDeque<>();
    }

    @Override
    public Iterator<Integer> iterator() {

        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                return currentElement < stack.size();
            }

            @Override
            public Integer next() {
                if(hasNext()){
                    currentElement ++;
                }
                return stack.pop();
            }
        };
    }
}
