package WildFarm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        while (!"End".equals(line)) {
            String[] animalInput = line.split("\\s+");
            Animal animal = createAnimal(animalInput);
            animal.makeSound();

            String[] foodInput = scanner.nextLine().split("\\s+");
            Food food = createFood(foodInput);
            animal.eat(food);
            System.out.println(animal);


            line = scanner.nextLine();
        }

    }

    private static Food createFood(String[] foodInput) {
        String foodType = foodInput[0];
        Integer foodQuantity = Integer.parseInt(foodInput[1]);

        switch (foodType) {
            case "Vegetable":
                return new Vegetable(foodQuantity);

            case "Meat":
                return new Meat(foodQuantity);

            default:
                throw new IllegalArgumentException("Cannot create this type of food");
        }
    }

    private static Animal createAnimal(String[] animalInput) {
        String type = animalInput[0];
        String name = animalInput[1];
        Double weight = Double.parseDouble(animalInput[2]);
        String livingRegion = animalInput[3];

        switch (type) {
            case "Cat":
                String breed = animalInput[4];
                return new Cat(type, name, weight, livingRegion, breed);

            case "Mouse":
                return new Mouse(type, name, weight, livingRegion);

            case "Zebra":
                return new Zebra(type, name, weight, livingRegion);

            case "Tiger":
                return new Tiger(type, name, weight, livingRegion);

            default:
                throw  new IllegalArgumentException("Such animal does not exist");
        }

    }

}
