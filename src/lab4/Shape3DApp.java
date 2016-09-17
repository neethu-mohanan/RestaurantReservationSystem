package lab4;

import java.util.Scanner;

public class Shape3DApp {

    public static void main(String agrs[]) 
    {
        Scanner Sc = new Scanner(System.in);
        int choice, number;
        double area = 0, volume1 = 0, volume2=0;
        System.out.println("Enter the total number of shapes:");
        int num = Sc.nextInt();
        System.out.println("Calculate both area and the volume? Y / N");
        char ch = (Sc.next()).charAt(0);
        System.out.println("Calculate only volume? Y or N");
        char chV=(Sc.next()).charAt(0);
        for (int i = 0; i < num; i++) 
        {
            System.out.println("Menu");
            System.out.println("1. Sphere");
            System.out.println("2. Cuboid");
            System.out.println("3. Cylinder");
            System.out.println("4. Pyramid");
            System.out.println("5. Cone");
            choice = Sc.nextInt();
            switch (choice) 
            {
                case 1:
                    System.out.println("Enter the number of spheres");
                    number = Sc.nextInt();
                    double radius;
                    Sphere sphere[] = new Sphere[number];
                    for (int j = 0; j < number; j++) 
                    {
                        System.out.println("Enter radius of sphere " + (j+1) + ":");
                        radius = Sc.nextDouble();
                        sphere[j] = new Sphere(radius);
                        if (ch == 'Y' || ch == 'y') 
                        {
                            area += sphere[j].findArea();
                            volume1 += sphere[j].Volume();
                        }
                        if (chV == 'Y' || chV == 'y') 
                		{
                			volume2 += sphere[j].Volume();
                		}
                    }
                    break;

                case 2:
                    System.out.println("Enter the number of cuboids");
                    number = Sc.nextInt();
                    double l, w, h;
                    Cuboid cuboid[] = new Cuboid[number];
                    for (int j = 0; j < number; j++) {
                    	System.out.println("Enter length of cuboid " + (j + 1) + ":");
                    	l = Sc.nextDouble();
                    	System.out.println("Enter width of cuboid " + (j + 1) + ":");
                    	w = Sc.nextDouble();
                    	System.out.println("Enter height of cuboid " + (j + 1) + ":");
                    	h = Sc.nextDouble();
                    	cuboid[j] = new Cuboid(l, w, h);
                    	if (ch == 'Y' || ch == 'y') 
                    	{
                    		area += cuboid[j].findArea();
                    		volume1 += cuboid[j].Volume();
                    	}
                    	if (chV == 'Y' || chV == 'y') 
                		{
                			volume2 += cuboid[j].Volume();
                		}
                    }
                    break;


                case 3:
                    System.out.println("Enter the number of cylinders");
                    number = Sc.nextInt();
                    Cylinder cyl[] = new Cylinder[number];
                    for (int j = 0; j < number; j++) {
                        System.out.println("Enter the radius of cylinder " + (j+1) + ":");
                        l = Sc.nextDouble();
                        System.out.println("Enter the height of cylinder " + (j+1) + ":");
                        w = Sc.nextDouble();

                        cyl[j] = new Cylinder(l, w);
                        if (ch == 'Y' || ch == 'y') 
                        {
                            area += cyl[j].findArea();
                            volume1 += cyl[j].Volume();
                        }
                        if (chV == 'Y' || chV == 'y') 
                        {
                            volume2 += cyl[j].Volume();
                        }
                    }
                    break;
                    
                case 4:
                	System.out.println("Enter the number of pyramids");
                	number = Sc.nextInt();
                	double lg, wg, hg;
                	Pyramid pyr[] = new Pyramid[number];
                	for (int j = 0; j < number; j++) {
                		System.out.println("Enter length, width and height of pyramid " + (j+1) + ":");
                		lg = Sc.nextDouble();
                		wg = Sc.nextDouble();
                		hg = Sc.nextDouble();
                		pyr[j] = new Pyramid(lg, wg, hg);
                		if (ch == 'Y' || ch == 'y') 
                		{
                			area += pyr[j].findArea();
                			volume1 += pyr[j].Volume();
                		}
                		if (chV == 'Y' || chV == 'y') 
                            volume2 += pyr[j].Volume();
                    }
                	break;
               case 5:
                    System.out.println("Enter the number of cones");
                    number = Sc.nextInt();
                    Cone cone[] = new Cone[number];
                    for (int j = 0; j < number; j++) 
                    {
                        System.out.println("Enter radius of cone " + (j+1) + ":");
                        lg = Sc.nextDouble();
                        System.out.println("Enter height of cone " + (j+1) + ":");
                        wg = Sc.nextDouble();
                        cone[j] = new Cone(lg, wg);
                        if (ch == 'Y' || ch == 'y') 
                        {
                            area += cone[j].findArea();
                            volume1 += cone[j].Volume();
                        }
                    }
                    break;

                default:
                    System.out.println("Invalid choice!");
                    i--;
            }
        }
        if (ch == 'Y' || ch == 'y') 
        {
            System.out.println("Total area = " + area );
            System.out.println("Total volume = " + volume1);
        }
        if (chV == 'Y' || chV == 'y') 
            System.out.println("Total volume = " + volume2);
        }
}
