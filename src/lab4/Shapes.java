package lab4;
//note lab3 is also lab4 only
public abstract class Shapes {
private String shapeName;
public Shapes(String name){
	shapeName=name;
}
public abstract double findArea();
public void printArea(){
	System.out.println("Area of"+shapeName+"="+findArea());
}
	
	
}
