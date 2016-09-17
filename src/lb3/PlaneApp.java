package lb3;
import java.util.*;

public class PlaneApp {

	public static void main(String[] args) {
		Scanner sr =new Scanner(System.in);
		Plane obj = new Plane();
		System.out.println("1. Show the number of empty seats");
		System.out.println("2. Show the list of empty seats");
		System.out.println("3. Show the list of customers together with their seat numbers in the order of the seat numbers");
		System.out.println("4. Show the list of customers together with their seat numbers in the order of the customer ID");
		System.out.println("5. Assign a customer to a seat");
		System.out.println("6. Remove a seat assignment");
		System.out.println("7. Quit");
		System.out.println("Enter the number of your choice:");
		int ch=sr.nextInt();
		do{
			switch(ch)
		    {
		    case 1:
			  obj.showNumEmptySeats();
			  break;
		    case 2:
		      obj.showEmptySeats();
		      break;
		      
		    case 3:
			      obj.showAssignedSeats(true);
			      break;
			      
		    case 4:
			      obj.showAssignedSeats(false);
			      break;
			      
		    case 5:
		    	System.out.println("Enter SeatID");
		    	int seatid= sr.nextInt();
		    	System.out.println("Enter Customer ID");
		    	int custid= sr.nextInt();
		    	obj.assignSeat(seatid,custid);
		    	break;
		    	
		    case 6:
		    	System.out.println("Enter SeatID to unassign customer from:");
		    	int seat= sr.nextInt();
		    	obj.unAssignSeat(seat);
		    	break;
		    }
			System.out.println("Enter your choice:");
			ch=sr.nextInt();
		}while(ch<7);
		sr.close();	

	}

}
