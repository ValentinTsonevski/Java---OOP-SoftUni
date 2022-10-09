package JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = parseInt(scanner.nextLine());

        int rows = dimensions[0];
        int cols = dimensions[1];

       Field field = new Field(rows,cols);
       Galaxy galaxy = new Galaxy(field);


        String command = scanner.nextLine();


        while (!command.equals("Let the Force be with you")) {
            int[] jedi = parseInt(command);
            int[] evil = parseInt(scanner.nextLine());

            int evilRow = evil[0];
            int evilCol = evil[1];

            galaxy.moveEvil(evilRow, evilCol);

            int jediRow = jedi[0];
            int jediCol = jedi[1];

            long starsCollected = galaxy.moveJedi(jediRow, jediCol);

            command = scanner.nextLine();

            System.out.println(starsCollected);
        }

    }

    private static int[] parseInt(String command) {
        return Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
