package Vehicles;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] vehicleParts = scanner.nextLine().split("\\s+");
        Vehicle car = createVehicle(vehicleParts);

        vehicleParts = scanner.nextLine().split("\\s+");
        Vehicle truck = createVehicle(vehicleParts);

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();
        vehicleMap.put("Car", car);
        vehicleMap.put("Truck", truck);

        int commandsCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < commandsCount; i++) {
            String[] commandParts = scanner.nextLine().split("\\s+");
            String commandType = commandParts[0];
            String vehicleType = commandParts[1];

            if (commandType.equals("Drive")) {
                double distance = Double.parseDouble(commandParts[2]);
                System.out.println(vehicleMap.get(vehicleType).drive(distance));
            }else if(commandType.equals("Refuel")) {
                double litres = Double.parseDouble(commandParts[2]);
                vehicleMap.get(vehicleType).refuel(litres);
            }
        }

        vehicleMap.values().forEach(System.out::println);
    }

    private static Vehicle createVehicle(String[] vehicleTokens) {
        String vehicleType = vehicleTokens[0];
        double fuelQuantity = Double.parseDouble(vehicleTokens[1]);
        double fuelConsumption = Double.parseDouble(vehicleTokens[2]);

        Vehicle vehicle = null;
        switch (vehicleType) {
            case "Car":
                vehicle = new Car(fuelQuantity, fuelConsumption);
                break;
            case "Truck":
                vehicle = new Truck(fuelQuantity, fuelConsumption);
        }
        return vehicle;
    }

}



