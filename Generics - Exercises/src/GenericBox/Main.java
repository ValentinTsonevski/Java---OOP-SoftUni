package GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        Box box = new Box();

        for (int i = 0; i < lines; i++) {
            String text = scanner.nextLine();
            box.add(text);
        }

        System.out.println(box);



    }
}
