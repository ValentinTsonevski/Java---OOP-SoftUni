package GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box {

private List<String> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(String element){
        values.add(element);
    }

    @Override
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();

        for (String value : values) {
            stringBuilder.append(String.format("%s: %s%n",value.getClass().getName(),value.toString()));
        }

        return stringBuilder.toString();
    }
}
