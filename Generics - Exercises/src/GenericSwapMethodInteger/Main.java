package GenericSwapMethodInteger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Box<Integer> box = new Box<>();

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            box.add(number);
        }

        String[] tokens = scanner.nextLine().split("\\s+");
        int index1 = Integer.parseInt(tokens[0]);
        int index2 = Integer.parseInt(tokens[1]);

        box.swap(index1,index2);

        System.out.println(box);


    }
}
