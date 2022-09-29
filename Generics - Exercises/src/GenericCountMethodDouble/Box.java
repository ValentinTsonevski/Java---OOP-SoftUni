package GenericCountMethodDouble;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> values;

    public Box() {
        values = new ArrayList<>();
    }

    public void add(T element){
      values.add(element);
    }

    public long countGreatItems(T element){
        return values.stream().filter(boxElement -> boxElement.compareTo(element) > 0).count();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (T value : values) {
        sb.append(String.format("%s: %s%n",value.getClass().getName(),value));
        }

        return sb.toString();
    }
}
