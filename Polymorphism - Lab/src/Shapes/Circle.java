package Shapes;

public class Circle extends Shape{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
        setArea(this.calculateArea());
        setPerimeter(this.calculatePerimeter());
    }

    @Override
    public double calculateArea() {
        return Math.PI * (2 * this.radius);
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * this.radius;
    }

    public final double getRadius() {
        return radius;
    }

}
