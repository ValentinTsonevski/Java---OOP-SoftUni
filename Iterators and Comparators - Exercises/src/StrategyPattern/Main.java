package StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    int lines = Integer.parseInt(scanner.nextLine());

        Set<Person> nameSet = new TreeSet<>(new ComparatorByNameLength());
        Set<Person> ageSet = new TreeSet<>(new ComparatorByAge());

        for (int i = 0; i < lines; i++) {

            String[] personInfo = scanner.nextLine().split(" ");

            String name = personInfo[0];
            int age = Integer.parseInt(personInfo[1]);

            Person person = new Person(name,age);

            ageSet.add(person);
            nameSet.add(person);
        }

        for (Person person : nameSet) {
            System.out.printf("%s %d%n",person.getName(),person.getAge());
        }

        for (Person person : ageSet) {
            System.out.printf("%s %d%n",person.getName(),person.getAge());
        }

    }
}
