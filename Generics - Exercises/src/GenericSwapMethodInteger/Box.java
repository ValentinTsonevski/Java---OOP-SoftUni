package GenericSwapMethodInteger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T> {

    private List<T> values;

    public Box() {
        values = new ArrayList<>();
    }

    public void add(T element){
        values.add(element);
    }

    public void swap(int index1,int index2){
        Collections.swap(values,index1,index2);
    }

    @Override
    public String toString() {
     StringBuilder sb = new StringBuilder();

        for (T value : values) {
            sb.append(String.format("%s: %s%n",value.getClass().getName(),value));
        }


        return sb.toString().toString();
    }
}
