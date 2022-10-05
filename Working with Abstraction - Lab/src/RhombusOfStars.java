import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rhombusSize = Integer.parseInt(scanner.nextLine());

        printTopHalf(rhombusSize);

        printSecondHalf(rhombusSize);

    }

    private static void printSecondHalf(int rhombusSize) {
        for (int starCount = rhombusSize - 1; starCount > 0 ; starCount--) {
            printStars(rhombusSize, starCount);
        }
    }

    private static void printTopHalf(int rhombusSize) {
        for (int starCount = 1; starCount <= rhombusSize; starCount++) {
          printStars(rhombusSize,starCount);
        }
    }

    private static void printStars(int rhombusSize, int starCount) {
        for (int i = 0; i < rhombusSize - starCount; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < starCount - 1; i++) {
            System.out.print("* ");

        }
        System.out.println("*");
    }
}
