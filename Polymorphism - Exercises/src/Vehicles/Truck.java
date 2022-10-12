package Vehicles;

public class Truck extends Vehicle {
    private final static double ADDITIONAL_CONSUMPTION = 1.6;
    private final static double FUEL_LEAK_PERCENTAGE = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        this.fuelConsumption = this.fuelConsumption + ADDITIONAL_CONSUMPTION;
    }

    @Override
    public void refuel(double litres) {
        litres = litres * FUEL_LEAK_PERCENTAGE;
        super.refuel(litres);
    }

}
