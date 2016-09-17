package lab4;

public class Sphere extends Circle implements Shape3D {
	public Sphere(double radius){
		super(radius);
	}

	@Override
	public double Volume() {
		return super.findArea()*radius*4/3;
	}

	@Override
	public void printVolume() {
		System.out.println("Volume of Sphere= "+Volume());
		
	}
	@Override
	public double findArea(){
		return 4*Math.PI*radius*radius;
		
	}
	

}
