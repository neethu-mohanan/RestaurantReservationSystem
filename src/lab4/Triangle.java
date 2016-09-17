package lab4;

public class Triangle extends Shapes{
	protected double width;
	protected double height;
	public Triangle (double w, double h){
		super("Triangle");
		width=w;
		height=h;
	}
	@Override
	public double findArea() {
		return 0.5*width*height;
	}

	public double getWidth(){ return width;}
	public double getHeight(){ return height;}
	}


