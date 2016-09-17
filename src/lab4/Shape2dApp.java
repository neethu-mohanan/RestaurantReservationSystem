package lab4;

import java.util.Scanner;

public class Shape2dApp {

    public static void main(String agrs[]) {
        Scanner Sc = new Scanner(System.in);
        int choice, number;
        double area = 0;
        System.out.println("Please enter the total number of shapes:");
        int num = Sc.nextInt();
        System.out.println("Do you wish to calculate area? Y or N");
        char ch = (Sc.next()).charAt(0);
        for (int i = 0; i < num; i++) {
            System.out.println("Choose:\n1.Circle\n2.Rectangle\n3.Square\n4.Triangle\n");
            choice = Sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("How many circles in the figure?");
                    number = Sc.nextInt();
                    double radius;
                    Circle c[] = new Circle[number];
                    for (int j = 0; j < number; j++) {
                        System.out.println("Enter radius of circle " + (j + 1) + ":");
                        radius = Sc.nextDouble();
                        c[j] = new Circle(radius);
                        if (ch == 'Y' || ch == 'y') {
                            area += c[j].findArea();
                        }

                    }

                    break;
                case 2:
                    System.out.println("How many rectangles in the figure?");
                    number = Sc.nextInt();
                    double l, w;
                    Rectangle r[] = new Rectangle[number];
                    for (int j = 0; j < number; j++) {
                        System.out.println("Enter length and width of rectangle" + j + ":");
                        l = Sc.nextDouble();
                        w = Sc.nextDouble();
                        r[j] = new Rectangle(l, w);
                        if (ch == 'Y' || ch == 'y') {
                            area += r[j].findArea();
                        }
                    }
                    break;
                case 3:
                    System.out.println("How many Squares in the figure?");
                    number = Sc.nextInt();
                    double lt;
                    Square s[] = new Square[number];
                    for (int j = 0; j < number; j++) {
                        System.out.println("Enter length of side of square" + j + ":");
                        lt = Sc.nextDouble();
                        s[j] = new Square(lt);
                        if (ch == 'Y' || ch == 'y') {
                            area += s[j].findArea();
                        }
                    }
                    break;
                case 4:
                    System.out.println("How many triangles in the figure?");
                    number = Sc.nextInt();
                    double lg, wg;
                    Triangle t[] = new Triangle[number];
                    for (int j = 0; j < number; j++) {
                        System.out.println("Enter base and height of triangle" + j + ":");
                        lg = Sc.nextDouble();
                        wg = Sc.nextDouble();
                        t[j] = new Triangle(lg, wg);
                        if (ch == 'Y' || ch == 'y') {
                            area += t[j].findArea();
                        }
                    }
                    break;
                default:
                    System.out.println("Incorrect choice!");
                    i--;
            }

        }

        System.out.println("Total area=" + area);



    }
}
