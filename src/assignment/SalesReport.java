package assignment;
import java.io.*;
import java.text.*;
import java.util.*;
/**
 * Generates the sales report on a monthly basis.
 * A staff member can enter a month number to generate the sales report, depending on it.
 * Months are represented by numbers, e.g. 1 for January, 2 for February, and so on.
 * @author shuvamnandi
 *
 */
public class SalesReport 
{
	/**
	 * Uses an array of objects of class SaleStructure to generate the sales report.
	 * The length of this array depends on the number of items that exist in the menu.
	 * If any menu item is updated or removed, the sales report accordingly changes.
	 */
	private static Scanner sc=new Scanner(System.in);
	private Sales sales=new Sales();
	private Menu menu=new Menu();
	private int width=menu.returnMaxNumOfDessert()+menu.returnMaxNumOfMainCourse()+menu.returnMaxNumOfDrink()+menu.returnMaxNumOfSetPackage();
	private SaleStructure matrix[];
	private Order order[];
	private SimpleDateFormat dateFormat2=new SimpleDateFormat("hh:mm|a|dd/MM/YY");
	/**
	 * Reads all the menu items into arrays of objects of interface MenuItem.
	 * Creates an array of object of class SalesStructure which will contain the sales data of 
	 * each menu item.
	 * @param month
	 */
	public SalesReport()
	{
		menu.readDessertData();
		menu.readMainCourseData();
		menu.readDrinkData();
		menu.readSetPackageData();
		width=menu.returnNumOfDessert()+menu.returnNumOfMainCourse()+menu.returnNumOfDrink()+menu.returnNumOfSetPackage();
		matrix=new SaleStructure[width];
		createReportStructure();
	}
	/**
	 * createReportStructure() loads matrix (array of object of class SalesStructure) with all the names 
	 * of all the menu items, one by one.
	 */
	public void createReportStructure()
	{
		int i, j;
		i=0;
		j=0;
		for(i=0;i<width;i++)
			matrix[i]=new SaleStructure();
		i=0;
		for(j=0;j<menu.returnNumOfDessert();i++, j++)
			matrix[i].setName(menu.returnDessert()[j].getName());
		for(j=0;j<menu.returnNumOfMainCourse();i++, j++)
			matrix[i].setName(menu.returnMainCourse()[j].getName());
		for(j=0;j<menu.returnNumOfDrink();i++, j++)
			matrix[i].setName(menu.returnDrink()[j].getName());
		for(j=0;j<menu.returnNumOfSetPackage();i++, j++)
			matrix[i].setName(menu.returnSetPackage()[j].getName());
	}
	/**
	 * generateReport() displays the number of times a particular menu item was 
	 * ordered in a particular month, and the total money earned from each sale of that 
	 * item. Also, it shows the total money earned from all sales, exclusive of taxes.
	 * @param month
	 */
	public void generateReport()
	{
		int month;
		do
		{
			System.out.print("Enter a month number for which sales report is to be generated: ");
			month=sc.nextInt();
			if(month <0 || month>12)
				System.out.println("Month number can not be less than 0 or more than 12.");
		}while(month<0 || month>12);
		sales.dataTransferFromFile();
		order=new Order[sales.returnNumOfOrder()];
		order=sales.returnOrderData();
		boolean generate=false;
		for(int i=0;i<sales.returnNumOfOrder();i++)
		{
			if(month==(order[i].returnDate().getMonth()+1))
			{
				for(int j=0;j<order[i].returnCount();j++)
				{
					for(int k=0;k<width;k++)
					{
						if(matrix[k].getName().equalsIgnoreCase(order[i].returnOrderItem()[j].getName()))
						{	
							matrix[k].increaseQuantity();
							matrix[k].setPrice(order[i].returnOrderItem()[j].getPrice());
						}
					}
				}
				generate=true;
			}
		}
		/*
		 * If there is are no orders for a particular month, a message will be shown 
		 * that no orders were placed in the month.
		 */
		if(generate)
		{
			float total=0;
			System.out.println("Sales Report for month " + month);
			System.out.println(String.format("%27s | %8s | %10s ", "Menu Item", "Quantity", "Total Revenue"));
			for(int j=0;j<width;j++)
			{
				if(matrix[j].getQuantity()>0)
					System.out.println(String.format("%27s | %8s | %10s ", matrix[j].getName(), matrix[j].getQuantity(), matrix[j].getPrice()));
			}
			for(int j=0;j<width;j++)
				total+=matrix[j].getPrice();
			System.out.println("Total Revenue for Month " + month+ ": SGD "+ total);
		}
		else
			System.out.println("No orders found.");
	}
}
