package VehiclesExtension;

public class Car extends Vehicle {
    private final static double ADDITIONAL_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption,double tankCapacity) {
        super(fuelQuantity, fuelConsumption,tankCapacity);
        this.fuelConsumption = this.fuelConsumption + ADDITIONAL_CONSUMPTION;
    }
}
