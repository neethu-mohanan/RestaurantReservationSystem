package lab4;

public class Cylinder extends Circle implements Shape3D {

    private double height;

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
        
    }

    @Override
    public double Volume() {
        return super.findArea() * height;
    }

    @Override
    public void printVolume() {
        System.out.println("Volume of Cuboid= " + Volume());

    }

    @Override
    public double findArea() {
        return 2 * Math.PI * radius * (radius + height);
    }
}
