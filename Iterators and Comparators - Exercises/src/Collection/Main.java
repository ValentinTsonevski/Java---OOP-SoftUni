package Collection;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String lines = scanner.nextLine();

        ListyIterator listyIterator = null;

        while (!lines.equals("END")){
        String[] commandParts = lines.split(" ");
        String commandName = commandParts[0];

        switch (commandName){

            case "Create":
            if(commandParts.length > 1){
                listyIterator = new ListyIterator(Arrays.copyOfRange(commandParts,1,commandParts.length));
            }    else{
                listyIterator = new ListyIterator();
            }
                break;

            case "Move":
                System.out.println(listyIterator.move());
                break;

            case "HasNext":
                System.out.println(listyIterator.hasNext());
                break;

            case "Print":
            try {
                listyIterator.print();
            }catch (IllegalStateException e){
                System.out.println("Invalid Operation!");
            }
                break;

            case "PrintAll":
                for (String element : listyIterator) {
                    System.out.print(element + " ");
                }
                System.out.println();
                break;

        }

            lines = scanner.nextLine();
        }


    }
}
