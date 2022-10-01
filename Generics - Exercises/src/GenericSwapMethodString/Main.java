package GenericSwapMethodString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Box<String> box = new Box<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            box.add(name);
        }

        String[] indices = scanner.nextLine().split("\\s+");
        int index1 = Integer.parseInt(indices[0]);
        int index2 = Integer.parseInt(indices[1]);

        box.swap(index1,index2);

        System.out.println(box);

    }
}
