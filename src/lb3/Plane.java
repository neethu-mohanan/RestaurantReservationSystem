package lb3;
public class Plane {
	private PlaneSeat[] seat;
	private int numEmptySeat;
	private PlaneSeat sort_seats[] = new PlaneSeat[12];
	
	Plane()
	{
		numEmptySeat = 12;
		seat = new PlaneSeat[12];
		
		for(int i=0; i<12; i++)
			seat[i] = new PlaneSeat(i+1);
	}
	
	PlaneSeat[] sortSeats()
	{	
		
		for(int i=0; i<12; i++)
		{
			sort_seats[i] = new PlaneSeat(seat[i].getSeatID());
			if(seat[i].isOccupied() == true)
				sort_seats[i].assign(seat[i].getCustomerID());
		}
		
		PlaneSeat temp = new PlaneSeat(0);
		for(int i=0 ; i<12; i++)
		{
			for(int j=i+1; j<12; j++)
			{
				if(sort_seats[i].getCustomerID() > sort_seats[j].getCustomerID())
				{
					temp = sort_seats[j];
					sort_seats[j] = sort_seats[i];
					sort_seats[i] = temp;
				}
			}
		}
		
		return sort_seats;
	}
	
	void showNumEmptySeats()
	{
			System.out.println("Number Of Empty Seats = " + numEmptySeat);
	}
	
	void showEmptySeats()
	{
		System.out.println("The following seats are empty : ");
		for(int i=0; i<12; i++)
		{
			if(seat[i].isOccupied() == false)
				System.out.println("Seat ID " + seat[i].getSeatID());
		}
	}
	
	void showAssignedSeats(boolean bySeatID)
	{
		System.out.println("The Seat Assignments are as follows : ");
		
		if(bySeatID)
		{
			for(int i=0;i<12;i++)
				if (seat[i].isOccupied())
					System.out.println("Seat ID " + seat[i].getSeatID() + " assigned to Customer ID " + seat[i].getCustomerID());
		}
		else
		{
			sort_seats = sortSeats();
			for(int i=0;i<12;i++)
				 if (sort_seats[i].isOccupied())
					 System.out.println("Seat ID " + sort_seats[i].getSeatID() + " assigned to Customer ID " + sort_seats[i].getCustomerID());
		}
	}
	
	void assignSeat(int seat_id, int cust_id)
	{
		if(seat[seat_id-1].isOccupied() == true)
			System.out.println("Seat Already Assigned to a Customer.");
		else
		{
			seat[seat_id-1].assign(cust_id);
			numEmptySeat--;
			System.out.println("Seat Assigned !");
		}
	}
	
	void unAssignSeat(int seat_id)
	{
		if(seat[seat_id-1].isOccupied() == false)
			System.out.println("SeatID does not exist !");
		else
		{
			seat[seat_id-1].unAssign();
			numEmptySeat++;
			System.out.println("Seat Unassigned !");
		}
	}
	
}
