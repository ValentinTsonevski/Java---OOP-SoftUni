package CardSuit;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Card Suits:");

        Arrays.stream(CardsSuit.values())
                .forEach(cardsSuit -> System.out.printf("Ordinal value: %d; Name value: %s%n"
                        ,cardsSuit.ordinal(),cardsSuit.name()));

    }
}
