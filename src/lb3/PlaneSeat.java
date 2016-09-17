package lb3;
public class PlaneSeat {
	private int seatID;
	private boolean assigned;
	private int customerID;
	
	PlaneSeat(int seat_id)
	{
		seatID = seat_id;
		assigned = false;
		customerID = 0;
	}
	
	public int getSeatID()
	{
		return seatID;
	}
	
	public int getCustomerID()
	{
		return customerID;
	}
	
	public boolean isOccupied()
	{
		return assigned;
	}
	
	public void assign(int cust_id)
	{
		customerID = cust_id;
		assigned = true;
	}
	
	public void unAssign()
	{
		customerID = 0;
		assigned = false;
	}
}
