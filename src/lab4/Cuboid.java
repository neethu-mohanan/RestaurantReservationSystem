package lab4;

public class Cuboid extends Rectangle implements Shape3D {
	private double height;
	public Cuboid(double l, double w, double h){
		super(l,w);
		height=h;
	}

	@Override
	public double Volume() {
		
		return super.findArea()*height;
	}

	@Override
	public void printVolume() {
		System.out.println("Volume of Cuboid= "+Volume());
		
	}
	@Override
	public double findArea(){
		return height*length+length*breadth+breadth*height;
	

}}
