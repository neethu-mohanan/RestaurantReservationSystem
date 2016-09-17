package lab4;

public class Rectangle extends Shapes{
protected double length, breadth;
public Rectangle (double l, double b){
	super("Rectangle");
	length=l;
	breadth=b;
}
@Override
public double findArea() {
	return length*breadth;
}

public double getLength(){ return length;}
public double getBreadth(){ return breadth;}
}