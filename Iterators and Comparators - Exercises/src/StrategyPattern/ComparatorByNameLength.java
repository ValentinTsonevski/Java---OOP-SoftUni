package StrategyPattern;

import java.util.Comparator;

public class ComparatorByNameLength implements Comparator<Person> {

    @Override
    public int compare(Person first, Person second) {
        char firstPersonSymbol = first.getName().toLowerCase().charAt(0);
        char secondPersonSymbol = second.getName().toLowerCase().charAt(0);

        if (first.getName().length() == second.getName().length()) {
            return Character.compare(firstPersonSymbol, secondPersonSymbol);
        } else {
            return Integer.compare(first.getName().length(), second.getName().length());
        }
    }
}
