package lab4;

public class Cone extends Circle implements Shape3D {

    private double h;

    public Cone(double r, double h) {
        super(r);
        this.h = h;
    }

    @Override
    public double Volume() {

        return (super.findArea() * h /3);
    }

    @Override
    public void printVolume() {
        System.out.println("Volume of Pyramid= " + Volume());

    }

    @Override
    public double findArea() {
        return (super.findArea() + Math.PI * radius * Math.sqrt(radius * radius + h * h));

    }
}