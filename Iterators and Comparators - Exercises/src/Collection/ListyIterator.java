package Collection;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String>{
    private List<String> elements;
    private int currentIndex;

    public ListyIterator (String... elements) {
        this.elements = List.of(elements);
        currentIndex = 0;
    }

    public boolean hasNext() {
        return currentIndex < elements.size() - 1;
    }

    public boolean move() {
        if (hasNext()) {
            currentIndex++;
            return true;
        }
        return false;
    }

    public void print() {
        if (this.elements.isEmpty()) {
            throw new IllegalStateException("Invalid Operation.");
        } else {
            System.out.println(this.elements.get(currentIndex));
        }
    }

    @Override
    public Iterator<String> iterator() {

        return new Iterator<String>() {
        int index;

            @Override
            public boolean hasNext() {
                return index < elements.size();
            }

            @Override
            public String next() {
                String element = elements.get(index);
                index++;
                return element;
            }
        };
    }
}
