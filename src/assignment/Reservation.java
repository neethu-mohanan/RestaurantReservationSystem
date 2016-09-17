package assignment;
import java.util.*;

/**
 * Represents the structure of a reservation that was made.
 * @author salonigupta
 *
 */
public class Reservation 
{
	/**
	 * Contains the restaurant details, which is used to access 
	 * the details of all tables.
	 * Also, the date when the reservation is made is stored. 
	 */
	protected Restaurant restaurant=new Restaurant();
	protected int size;
	protected int start;
	protected int end;
	protected int contactNo;
	protected int tableID;
	protected Date date=new Date();
	protected String name;
	protected MemberFile memF=new MemberFile();
	protected boolean available;
	protected Member[] memberList=new Member[100];
	protected long d;
	/**
	 * Default constructor of Reservation class.
	 */
	public Reservation()
	{
		date=null;
		name=null;
		tableID=0;
		contactNo=0;
		size=0;
		available=false;
	}
	/**
	 * Constructor which assigns the variables of class Reservation,
	 * according to the parameters.
	 * @param customerName
	 * @param table
	 * @param no
	 * @param capacity
	 */
	public Reservation(String customerName, int table, int no, int capacity)
	{
		date=new Date();
		name=customerName;
		tableID=table;
		contactNo=no;
		size=capacity;
		available=false;
	}
	/**
	 * Returns the date of the reservation.
	 * @return date
	 */
	public Date returnDate()
	{
		return date;
	}
	/**
	 * Returns the size of the table of reservation,
	 *  i.e. the number of seats in the table reserved.
	 * @return size
	 */
	public int returnSize()
	{
		return size;
	}
	/**
	 * Returns the name of the customer who made the reservation.
	 * @return name
	 */
	public String returnName()
	{
		return name;
	}
	/**
	 * Returns the table ID of the table reserved.
	 * @return tableID
	 */
	public int returnTableID()
	{
		return tableID;
	}
	/**
	 * Returns the contact no of the customer.
	 * @return contactNo
	 */
	public int returnContactNo()
	{
		return contactNo;
	}
	/**
	 * Returns the details of the tables, which is inside an object of the class Restaurant
	 * @return restaurant
	 */
	public Restaurant returnRestaurantDetails()
	{
		return restaurant;
	}
	/**
	 * Returns whether the reservation is valid or not. True means it has expired, while false means a table is still reserved.
	 * @return available
	 */
	public boolean returnAvailiability()
	{
		return available;
	}
	/**
	 * Sets the date of the reservation to the one specified by the parameter. 
	 * @param date
	 */
	public void setDate(Date date)
	{
		this.date=date;
	}
	/**
	 * Sets the availability of the reservation to true or false, using the parameter.
	 * @param avail
	 */
	public void setAvailability(boolean avail)
	{
		available=avail;
	}
}

