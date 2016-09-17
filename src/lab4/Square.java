package lab4;

public class Square extends Rectangle {
private double side;
	public Square(double a) {
		super(a,a);
		side=a;
	}
	public double getSide(){ return side;}
}
