package lab3;
import java.util.*;
public class PlaneApp {
	private static Scanner sc=new Scanner(System.in);
	private static Plane airplane=new Plane();
	public static void main(String[] args) {
		int choice;
		System.out.println("1. Show the number of empty seats");
		System.out.println("2. Show the list of empty seats");
		System.out.println("3. Show the list of customers together with their seat numbers in the order of the seat numbers");
		System.out.println("4. Show the list of customers together with their seat numbers in the order of the customer ID");
		System.out.println("5. Assign a customer to a seat");
		System.out.println("6. Remove a seat assignment");
		System.out.println("7. Quit");
		do
		{
			System.out.println("Enter your choice");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:airplane.showNumEmptySeats(); break;
			case 2:airplane.showEmptySeats(); break;
			case 3:airplane.showAssignedSeats(true); break;
			case 4:airplane.showAssignedSeats(false); break;
			case 5:	System.out.println("Enter a seat ID to assign to");
					int seatID=sc.nextInt();
					System.out.println("Enter a customer ID");
					int customerID=sc.nextInt();
					airplane.assignSeat(seatID, customerID);
					break;
			case 6: System.out.println("Enter a seat ID to unassign");
					int seat=sc.nextInt();
					airplane.unassignSeat(seat);
					break;
			case 7:System.out.println("Program terminating");break;
			default:System.out.println("Invalid choice!");
			}
		}while(choice<7);
	}
}
