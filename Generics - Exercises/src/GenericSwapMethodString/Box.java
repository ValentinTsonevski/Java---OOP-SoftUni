package GenericSwapMethodString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T> {
    private List<T> values;

    public Box() {
        values = new ArrayList<>();
    }

    public void add(T element){
        this.values.add(element);
    }

    public void swap(int firstIndex,int secondIndex){
        Collections.swap(values,firstIndex,secondIndex);
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
