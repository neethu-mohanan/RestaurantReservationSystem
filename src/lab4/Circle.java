package lab4;

public class Circle extends Shapes {

    protected double radius;

    public Circle(double r) {
        super("Circle");
        radius = r;
    }

    @Override
    public double findArea() {
        return Math.PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }
}
