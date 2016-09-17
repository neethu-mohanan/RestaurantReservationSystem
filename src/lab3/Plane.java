package lab3;

public class Plane 
{
	private PlaneSeat [] seat;
	private PlaneSeat[] newPlaneSeat=new PlaneSeat[12];
	private static int numEmptySeat;
	public class Window{
		PlaneSeat [] s=seat;
	}
	public Plane()
	{
		seat=new PlaneSeat[12];
		this.numEmptySeat=12;
		for(int i=0;i<12;i++)
			seat[i]=new PlaneSeat(i+1);
	}
	public void showNumEmptySeats()
	{
		System.out.println("Number of Empty Seats: " + numEmptySeat);
	}
	public void showEmptySeats()
	{
		System.out.println("Empty Seats Details: ");
		for(int i=0;i<12;i++)
		{
			if(!seat[i].isOccupied())
				System.out.println("Seat ID: " + seat[i].getSeatID());
		}
	}
	public void showAssignedSeats(boolean bySeatId)
	{
		System.out.println("Assigned Seats Details: ");
		for(int i=0;i<12;i++)
		{
			if(seat[i].isOccupied())
			{
				if(bySeatId)
				{
					System.out.print("Seat ID: " + seat[i].getSeatID());
					System.out.println(" Customer ID: " + seat[i].getCustomerID());
				}
				else
				{
					PlaneSeat[] newSeat;
					newSeat=sortSeats();
					if(newSeat[i].getCustomerID()!=0)
					{
					System.out.print("Seat ID: " + newSeat[i].getSeatID());
					System.out.println(" Customer ID: " + newSeat[i].getCustomerID());
					}
				}
			}
		}
	}
	public void assignSeat(int seatId, int cust_id)
	{
		int index=seatId-1;
		if (seat[index].isOccupied())
			System.out.println("Seat with seat ID " + seatId + " is not available.");
		else
		{
			seat[index].assign(cust_id);
			numEmptySeat--;
		}
	}
	public void unassignSeat(int seatId)
	{
		int index=seatId-1;
		if (!seat[index].isOccupied())
			System.out.println("Seat with seat ID " + seatId + " is not occupied.");
		else
		{
			seat[index].unAssign();
			numEmptySeat++;
		}
	}
	public PlaneSeat[] sortSeats()
	{	
		PlaneSeat[] newPlaneSeat=new PlaneSeat[12];
		newPlaneSeat=this.seat;
		PlaneSeat temp;
		for(int i=1;i<12;i++)
		{
			for(int j=i;j>0;j--)
			{
				if(newPlaneSeat[j].getCustomerID()<newPlaneSeat[j-1].getCustomerID())
				{
					temp=newPlaneSeat[j-1];
					newPlaneSeat[j-1]=newPlaneSeat[j];
					newPlaneSeat[j]=temp;
				}
				else
					break;
			}
		}
		return newPlaneSeat;
	}
}
