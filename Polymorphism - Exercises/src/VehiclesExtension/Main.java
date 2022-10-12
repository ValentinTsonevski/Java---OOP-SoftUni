package VehiclesExtension;

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

        vehicleParts = scanner.nextLine().split("\\s+");
        Vehicle bus = createVehicle(vehicleParts);

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();
        vehicleMap.put("Car", car);
        vehicleMap.put("Truck", truck);
        vehicleMap.put("Bus", bus);

        int commandsCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < commandsCount; i++) {
            String[] commandParts = scanner.nextLine().split("\\s+");
            String commandType = commandParts[0];
            String vehicleType = commandParts[1];

            if (commandType.equals("Drive")) {
                double distance = Double.parseDouble(commandParts[2]);
                Vehicle vehicle = vehicleMap.get(vehicleType);

              if(vehicle instanceof Bus){
                 bus.setFuelConsumption(bus.getFuelConsumption() + 1.4);
                  System.out.println(bus.drive(distance));
                  bus.setFuelConsumption(bus.getFuelConsumption() - 1.4);
                  continue;
              }
                System.out.println(vehicle.drive(distance));

            } else if (commandType.equals("Refuel")) {
                double litres = Double.parseDouble(commandParts[2]);
                vehicleMap.get(vehicleType).refuel(litres);
            } else if (commandType.equals("DriveEmpty")) {
                double distance = Double.parseDouble(commandParts[2]);
                System.out.println(vehicleMap.get(vehicleType).drive(distance));
            }
        }

        vehicleMap.values().forEach(System.out::println);
    }

    private static Vehicle createVehicle(String[] vehicleTokens) {
        String vehicleType = vehicleTokens[0];
        double fuelQuantity = Double.parseDouble(vehicleTokens[1]);
        double fuelConsumption = Double.parseDouble(vehicleTokens[2]);
        double tankCapacity = Double.parseDouble(vehicleTokens[3]);

        Vehicle vehicle = null;
        switch (vehicleType) {
            case "Car":
                vehicle = new Car(fuelQuantity, fuelConsumption, tankCapacity);
                break;

            case "Truck":
                vehicle = new Truck(fuelQuantity, fuelConsumption, tankCapacity);
                break;

            case "Bus":
                vehicle = new Bus(fuelQuantity, fuelConsumption, tankCapacity);
                break;
        }
        return vehicle;
    }

}



