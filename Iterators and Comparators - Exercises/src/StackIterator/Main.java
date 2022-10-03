package StackIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      String input = scanner.nextLine();


      while (!input.equals("END")){
        String[] commandParts = input.split(", ");
        String commandName = commandParts[0];

        switch (commandName){

            case "Push":

                break;

            case "Pop":

                break;

        }




          input = scanner.nextLine();
      }



    }
}
