package assignment;

import java.io.*;
import java.util.*;

/**
 * Inherited base class of ReservationFile, which adds items in an order, removes an item from the order, prints the current order
 * details, prints the order invoice, and adds the details on the text file.
 * @author neethumohanan
 *
 */
public class OrderFile extends ReservationFile
{
	private int count;
	private Date date;
	private Menu menu=new Menu();
	private OrderItem [] orderedItems;
	private Dessert [] dessert = new Dessert[menu.returnMaxNumOfDessert()];
	private MainCourse [] mainCourse = new MainCourse[menu.returnMaxNumOfMainCourse()];
	private Drink [] drink = new Drink[menu.returnMaxNumOfDrink()];
	private MenuItem [] setPackage = new Drink[menu.returnMaxNumOfSetPackage()];
	private final int maxNumOfOrderItem=50;
	private String staffName;
	public Order order;
	public OrderFile()
	{
		super();
		order=null;
		count=0;
		orderedItems=null;
	}
	public OrderFile(String customerName, int table, int no, int capacity, String staffName, float dis) 
	{
		super(customerName, table, no, capacity);
		orderedItems=new OrderItem[maxNumOfOrderItem];
		date=new Date();
		this.staffName=staffName;
		order=new Order(orderedItems, date, table, count, staffName, dis);
	}
	/**
	 * Returns the number of items placed in order.
	 * @return count
	 */
	public int returnCount()
	{
		return count;
	}
	/**
	 * Returns the order details.
	 * @return order
	 */
	public Order returnOrder()
	{
		return order;
	}
	/**
	 * Returns the time and date when the order was placed at. 
	 */
	public Date returnDate()
	{
		return date;
	}
	/**
	 * Adds a dessert item to the current order.
	 * @throws IOException
	 */
	public void addDessertOrder() throws IOException
	{
		boolean add=false;
		int item;
		menu=new Menu();
		menu.readDessertData();
		menu.printDesserts();
		dessert=menu.returnDessert();
		System.out.println("Enter a dessert number");
		item=sc.nextInt();
		if(item>0 && item<=menu.returnNumOfDessert())
		{
			add=true;
			orderedItems[count]=new OrderItem(dessert[item-1].getName(), dessert[item-1].getDescription(), dessert[item-1].ifExists(), dessert[item-1].getPrice());
			count++;
			System.out.println(dessert[item-1].getName()+ " added to the order.");
		}
		if(!add)
			System.out.println(item+" does not exist in the menu.");
	}
	/**
	 * Adds a main course item to the current order.
	 * @throws IOException
	 */
	public void addMainCourseOrder() throws IOException
	{
		boolean add=false;
		int item;
		menu=new Menu();
		menu.readMainCourseData();
		menu.printMainCourse();
		mainCourse=menu.returnMainCourse();
		System.out.println("Enter a main course item number");
		item=sc.nextInt();
		if(item>0 && item<=menu.returnNumOfMainCourse())
		{
			add=true;
			orderedItems[count]=new OrderItem(mainCourse[item-1].getName(), mainCourse[item-1].getDescription(), mainCourse[item-1].ifExists(), mainCourse[item-1].getPrice());
			count++;
			System.out.println(mainCourse[item-1].getName()+ " added to the order.");
		}
		if(!add)
			System.out.println(item+" does not exist in the menu.");
	}
	/**
	 * Adds a drink item to the current order.
	 * @throws IOException
	 */
	public void addDrinkOrder() throws IOException
	{
		boolean add=false;
		int item;
		menu=new Menu();
		menu.readDrinkData();
		menu.printDrinks();
		drink=menu.returnDrink();
		System.out.println("Enter a drink number");
		item=sc.nextInt();
		if(item>0 && item<=menu.returnNumOfDrink())
		{
			add=true;
			orderedItems[count]=new OrderItem(drink[item-1].getName(), drink[item-1].getDescription(), drink[item-1].ifExists(), drink[item-1].getPrice());
			count++;
			System.out.println(drink[item-1].getName()+ " added to the order.");
		}
		if(!add)
			System.out.println(item+" does not exist in the menu.");	
	}
	/**
	 * Adds a set package to the current order.
	 * @throws IOException
	 */
	public void addSetPackageOrder() throws IOException
	{
		boolean add=false;
		int item;
		menu=new Menu();
		menu.readSetPackageData();
		menu.printSetPackages();
		add=false;
		setPackage=menu.returnSetPackage();
		System.out.println("Enter a set package number");
		item=sc.nextInt();
		if(item>0 && item<=menu.returnNumOfSetPackage())
		{
			add=true;
			orderedItems[count]=new OrderItem(setPackage[item-1].getName(), setPackage[item-1].getDescription(), setPackage[item-1].ifExists(), setPackage[item-1].getPrice());
			count++;
			System.out.println(setPackage[item-1].getName()+ " added to the order.");
		}
		if(!add)
			System.out.println(item+" does not exist in the menu.");
	}
	/**
	 * checkStaff() checks whether the person taking a order is a waiter or not. Only waiters can take orders.
	 * @throws IOException
	 */
	public void checkStaff() throws IOException
	{
		System.out.print("Enter staff name: ");
		String name=brStream.readLine();
		StaffFile staF=new StaffFile();
		staF.readStaffData();
		Staff [] staff=staF.returnStaff();
		boolean found=false, waiter=false;
		do
		{
			for(int i=0;i<staF.returnNumOfStaff();i++)
			{
				if(name.equalsIgnoreCase(staff[i].getName()))
				{
					if(staff[i].getJobTitle().equalsIgnoreCase("Waiter"))
					{
						waiter=true;
						found=true;
						break;
					}
				}
			}
			if(!waiter)
			{
				if(!found)
				{
					System.out.print("Staff data with staff name "+name+ " does not exist. Please enter again: ");
					name=brStream.readLine();
				}
				else
				{
					System.out.print("Only a waiter can create an order. Please enter again: ");
					name=brStream.readLine();
				}
			}
			else if(!found)
			{
				System.out.print("Staff data with staff name "+name+ " does not exist. Please enter again: ");
				name=brStream.readLine();
			}
			
		}while(!found || !waiter);
		staffName=name;	
	}
	/**
	 * createOrder() displays the items that can be ordered and lets the user select a category to order from.
	 * @param ordered
	 * @throws IOException
	 */
	public void createOrder(boolean ordered) throws IOException
	{
		int choice;
		if(!ordered)
			checkStaff();
		System.out.println("ORDER MENU");
		System.out.println("1. Desserts");
		System.out.println("2. Main course items");
		System.out.println("3. Drinks");
		System.out.println("4. Set Packages");
		System.out.println("5. Quit");
		System.out.print("Enter your choice: ");
		choice=sc.nextInt();
		while(choice>=1 && choice<=4)
		{
			switch(choice)
			{
				case 1: addDessertOrder();break;
				case 2: addMainCourseOrder();break;
				case 3: addDrinkOrder();break;
				case 4: addSetPackageOrder();break;
			}
			System.out.print("Enter your choice again: ");
			choice=sc.nextInt();
		}
		System.out.println("Going back to home screen..");
	}
	/**
	 * removeOrder() removes an item from the current order, if it exists in the order placed.
	 * @throws IOException
	 */
	public void removeOrder() throws IOException
	{
		boolean removed=false;
		String item;
		System.out.println("Enter an item name");
		item=brStream.readLine();
		for(int i=0;i<count;i++)
		{
			if(item.equalsIgnoreCase(orderedItems[i].getName()))
			{
				removed=true;
				orderedItems[i]=new OrderItem();
				System.out.println(item+ " removed from the order.");
			}
		}
		if(!removed)
			System.out.println(item+" does not exist in the order.");
	}
	/**
	 * calculateTotal() calculates the total by using the prices of each individual items.
	 * @return total
	 */
	public float calculateTotal()
	{
		float total=0;
		for(int i=0;i<count;i++)
			total+=orderedItems[i].getPrice();
		if(count>0)
			order.setTotal(total);
		return total;
	}
	/**
	 * dataToFile() writes the details of the order on the text file.
	 */
	public void dataToFile()
	{
		String name=this.name;
		int tableid=this.tableID;
		float total;
		calculateTotal();
		if(order.returnDiscount()>0)
			total=order.returnTotalAfterDiscount();
		else
			total=order.returnTotalInclusiveOfTaxes();
		try
		{
			BufferedWriter bwStream=new BufferedWriter(new FileWriter("Order.txt", true));
			PrintWriter pwStream=new PrintWriter(bwStream);
			pwStream.print(this.dateFormat2.format(date)+"|"+name+"|"+tableid+"|"+count+"|");
			if(count>0)
			{
				for(int i=0;i<count;i++)
				{
					if(orderedItems[i].ifExists())
						pwStream.print(orderedItems[i].getName()+"-"+orderedItems[i].getPrice()+"-");
				}
			pwStream.print("|"+total);
			pwStream.println();
			pwStream.close();
			}
		}
		catch(IOException e)
		{
			System.out.println("IO Error!\n"+e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}
	}
	/**
	 * printOrder() lets the user to view the current order details when the order has not been finalised, and accordingly, new items can
	 * be added or existing items can be removed.
	 */
	public void printOrder()
	{
		if(count==0)
        	System.out.println("Order does not exist.");
        else
        {
        	System.out.println("Order Details");
        	System.out.println(String.format("%5s | %27s | %5s ", "SNo", "Drinks", "Price"));
    		for(int i=0, j=0;i<count;i++)
            {
        		if(orderedItems[i].ifExists())
        		{
        			System.out.println(String.format("%5d | %27s | %.2f ", (j+1), orderedItems[i].getName(), orderedItems[i].getPrice()));
        			j++;
        		}
            }
        }
	}
	/**
	 * printOrderInvoice() prints the order invoice has been finalised.
	 */
	public void printOrderInvoice()
	{
		String name=this.name;
		int contactNo=this.contactNo;
		if(count==0)
        	System.out.println("Order does not exist.");
        else
        {
        	System.out.println("----------------------------------------------------------------------");
        	System.out.println(String.format("%40s", "Maa Ki Rasoi"));
        	System.out.println(String.format("%48s", "Authentic Indian Restaurant"));
        	System.out.println(String.format("%47s", "Contact No: +65-65231100"));
        	System.out.println("----------------------------------------------------------------------");
        	System.out.println(String.format("%41s", "Order Invoice"));
        	System.out.println("Table ID: "+ order.returnTableID());
        	System.out.println("Customer Name: "+ name);
        	System.out.println("Contact No: "+ contactNo); 
        	System.out.println("Order Created By: "+ staffName);
        	System.out.println(dateFormat1.format(date));
        	System.out.println("----------------------------------------------------------------------");
        	System.out.println(String.format("%5s  %27s  %5s ", "SNo", "Item", "Price"));
            for(int i=0, j=0;i<count;i++)
            {
        		if(orderedItems[i].ifExists())
        		{
        			System.out.println(String.format("%5d  %27s  %.2f ", (j+1), orderedItems[i].getName(), orderedItems[i].getPrice()));
        			j++;
        		}
            }
            System.out.println();
            System.out.println("----------------------------------------------------------------------");
        	System.out.println();
        	if(order.returnDiscount()>0)
                System.out.println(String.format("%35s  %.2f", "Discount %",  100*order.returnDiscount()));
            System.out.println(String.format("%35s  %.2f", "Total : SGD ",  order.returnTotal()));
            System.out.println(String.format("%35s  %.2f", "7% GST : SGD ",  order.returnTotal()*0.07));
            System.out.println(String.format("%35s  %.2f", "10% Service Tax : SGD ",  order.returnTotal()*0.1));
            System.out.println(String.format("%35s  %.2f", "Total (inclusive of taxes) : SGD ",  order.returnTotalInclusiveOfTaxes()));
            if(order.returnDiscount()>0)
            	System.out.println(String.format("%35s  %.2f", "Total (after discount) : SGD ",  order.returnTotalAfterDiscount()));
            System.out.println("----------------------------------------------------------------------");
        	System.out.println(String.format("%46s", "Thank you for dining with us!"));
            System.out.println(String.format("%42s", "Hope to see you again!"));
        }
	}
}