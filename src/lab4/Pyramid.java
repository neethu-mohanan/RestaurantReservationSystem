package lab4;

public class Pyramid extends Triangle implements Shape3D {
	private double height;
	public Pyramid(double l, double w, double h){
		super(l,w);
		height = h;
	}

	@Override
	public double Volume() {
		
		return super.findArea()*height/3;
	}

	@Override
	public void printVolume() {
		System.out.println("Volume of Pyramid= "+Volume());
		
	}
	@Override
	public double findArea(){
		return 4*super.findArea()+width*width;
		
	}
	

}
