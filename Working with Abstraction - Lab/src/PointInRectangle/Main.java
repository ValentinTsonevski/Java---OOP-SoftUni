package PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] cordinates = parseInt(scanner);
        int xBottomLeft = cordinates[0];
        int yBottomLeft = cordinates[1];
        int xTopRight = cordinates[2];
        int yTopRight = cordinates[3];

        Point bottomLeft = new Point(xBottomLeft,yBottomLeft);
        Point topRight = new Point(xTopRight,yTopRight);

        Rectangle rectangle = new Rectangle(bottomLeft,topRight);

        int count = Integer.parseInt(scanner.nextLine());

        printContains(scanner, rectangle, count);


    }

    private static void printContains(Scanner scanner, Rectangle rectangle, int count) {
        for (int i = 0; i < count; i++) {
        int[] currentPointCordinates = parseInt(scanner);

        int currentPointCordinate = currentPointCordinates[0];
        int currentPointCordinate2 = currentPointCordinates[1];

        Point currentPoint = new Point(currentPointCordinate,currentPointCordinate2);

            System.out.println(rectangle.contains(currentPoint));
        }
    }

    private static int[] parseInt(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
