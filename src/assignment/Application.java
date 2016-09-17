package assignment;

import java.io.*;
import java.util.*;
/**
 * Runs the whole restaurant reservation system.
 * @author shuvamnandi
 */
public class Application
{
	private static Scanner sc=new Scanner(System.in);
	private static BufferedReader brStream=new BufferedReader(new InputStreamReader(System.in));
	private static MemberFile memF=null;
	private static StaffFile staF=null;
	private static OrderFile ordF=null;
	public Application()
	{
		ordF=new OrderFile();
	}
	/**
	 * clearDessert() clears the content of Desserts text file, so that modified data can be rewritten if any menu item is removed or
	 * edited. 
	 * @param choice controls whether a menu item is to be removed or edited.
	 * @throws IOException
	 */
	public void clearDessert(int choice) throws IOException
	{
		Menu menu=new Menu();
		menu.readDessertData();
		BufferedWriter bwStream=new BufferedWriter(new FileWriter("Desserts.txt"));
		PrintWriter pwStream=new PrintWriter(bwStream);
		pwStream.print("");
		pwStream.close();
		if(choice==0)
			menu.removeDessert();
		if(choice==1)
			menu.editDessert();
	}
	/**
	 * clearMainCourse() clears the content of Main Course Items text file, so that modified data can be rewritten if any menu item is removed or
	 * edited. 
	 * @param choice controls whether a menu item is to be removed or edited.
	 * @throws IOException
	 */
	public void clearMainCourse(int choice) throws IOException
	{
		Menu menu=new Menu();
		menu.readMainCourseData();
		BufferedWriter bwStream=new BufferedWriter(new FileWriter("Main Course Items.txt"));
		PrintWriter pwStream=new PrintWriter(bwStream);
		pwStream.print("");
		pwStream.close();
		if(choice==0)
			menu.removeMainCourse();
		if(choice==1)
			menu.editMainCourse();
	}
	/**
	 * clearDrink() clears the content of Drinks text file, so that modified data can be rewritten if any menu item is removed or
	 * edited. 
	 * @param choice controls whether a menu item is to be removed or edited.
	 * @throws IOException
	 */
	public void clearDrink(int choice) throws IOException
	{
		Menu menu=new Menu();
		menu.readDrinkData();
		BufferedWriter bwStream=new BufferedWriter(new FileWriter("Drinks.txt"));
		PrintWriter pwStream=new PrintWriter(bwStream);
		pwStream.print("");
		pwStream.close();
		if(choice==0)
			menu.removeDrink();
		if(choice==1)
		{
			SalesReport sr=new SalesReport();
			sr.generateReport();
			menu.editDrink();
		}
	}
	/**
	 * clearSetPackage() clears the content of Packages text file, so that modified data can be rewritten if any menu item is removed or
	 * edited. 
	 * @param choice controls whether a menu item is to be removed or edited.
	 * @throws IOException
	 */
	public void clearSetPackage(int choice) throws IOException
	{
		Menu menu=new Menu();
		menu.readSetPackageData();
		BufferedWriter bwStream=new BufferedWriter(new FileWriter("Packages.txt"));
		PrintWriter pwStream=new PrintWriter(bwStream);
		pwStream.print("");
		pwStream.close();
		if(choice==0)
			menu.removeSetPackage();
		if(choice==1)
			menu.editSetPackage();
	}
	/**
	 * clearReservation() clears the content of the Reservation file, so that modified data can be rewritten while canceling reservations.
	 * @throws IOException
	 */
	public static void clearReservation() throws IOException
	{
		BufferedWriter bwStream=new BufferedWriter(new FileWriter("Reservation.txt"));
		PrintWriter pwStream=new PrintWriter(bwStream);
		pwStream.print("");
		pwStream.close();
	}
	/**
	 * removeReservation() 
	 * @param res brings the data of all the reservations which is used to return an array of objects of class Reservation.
	 * @throws IOException
	 */
	public static void removeReservation(ReservationFile res) throws IOException
	{
		res.dataTransferFromFile();
		boolean expired=false;
		for(int i=0;i<res.returnNumOfReservation();i++)
		{
			Date now=new Date();
			if(now.getHours()==res.returnReservationInfo()[i].returnDate().getHours())
				if(now.getMinutes()>res.returnReservationInfo()[i].returnDate().getMinutes())
				{
					expired=true;
					res.returnReservationInfo()[i].setAvailability(true);
				}
			
			if(now.getHours()>res.returnReservationInfo()[i].returnDate().getHours())
			{	
					expired=true;
					res.returnReservationInfo()[i].setAvailability(true);
			}
			/*if(now.getMinutes()>res.returnReservationInfo()[i].returnDate().getMinutes())
			{
				expired=true;
				res.returnReservationInfo()[i].setAvailability(true);
			}*/
		}
		if(expired)
		{
			clearReservation();
			res.removeReservationRewrite();
		}
	}
	/**
	 * Checks which tables are available and can be booked by a customer, depending on the size.
	 * @param resF brings the data of all the reservations which is used to return an array of objects of class Reservation.
	 * @param size is used while checking the availability of tables for a particular size.
	 */
	public static void checkReservation(ReservationFile resF, int size) 
	{
		resF.dataTransferFromFile();
		Restaurant rest;
		boolean check[]=new boolean[resF.returnNumOfReservation()];
		int tableNoRes[]=new int[resF.returnNumOfReservation()];
		for(int i=0;i<resF.returnNumOfReservation();i++)
			check[i]=false;
		rest=resF.returnRestaurantDetails();
		for(int i=0;i<resF.returnNumOfReservation();i++)
		{
			if(!resF.returnReservationInfo()[i].returnAvailiability())
			{
				tableNoRes[i]=resF.returnReservationInfo()[i].returnTableID();
				rest.book(tableNoRes[i]);
				check[i]=true;
			}
		}
		System.out.println("A total of " + rest.checkAvailability(size) + " tables are available with capacity " + ((size+1)/2)*2);
	}
	/**
	 * Checks which tables are available and can be booked by a customer. 
	 * @param resF brings the data of all the reservations which is used to return an array of objects of class Reservation.
	 */
	public static boolean checkAllReservations(ReservationFile resF) 
	{
		boolean allOccupied=false;
		resF.dataTransferFromFile();
		Restaurant rest;
		boolean check[]=new boolean[resF.returnNumOfReservation()];
		int tableNoRes[]=new int[resF.returnNumOfReservation()];
		for(int i=0;i<resF.returnNumOfReservation();i++)
			check[i]=false;
		rest=resF.returnRestaurantDetails();
		for(int i=0;i<resF.returnNumOfReservation();i++)
		{
			if(!resF.returnReservationInfo()[i].returnAvailiability())
			{
				tableNoRes[i]=resF.returnReservationInfo()[i].returnTableID();
				rest.book(tableNoRes[i]);
				check[i]=true;
			}
		}
		int num=rest.checkAllAvailability();
		if(num==0)
			allOccupied=true;
		return allOccupied;
	}
	/**
	 * printHomeScreen() prints the Home Screen of the restaurant.
	 */
	public static void printHomeScreen()
	{
		System.out.println("HOME SCREEN");
		System.out.println("1. Print menu");
		System.out.println("2. Edit menu");
		System.out.println("3. Add staff");
		System.out.println("4. Print staff information");	
		System.out.println("5. Add member");
		System.out.println("6. Print member information");	
		System.out.println("7. Order food");
		System.out.println("8. View order");
		System.out.println("9. Remove item from the order");
		System.out.println("10. Finalise order");
		System.out.println("11. Reserve a table");
		System.out.println("12. Check-in or check for a table reservation");
		System.out.println("13. Remove a table reservation");
		System.out.println("14. Check specific table availability");
		System.out.println("15. Check all table availabilities");
		System.out.println("16. Print order invoice");
		System.out.println("17. Generate sales report based on a monthly basis");
		System.out.println("18. Quit");
	}
	/**
	 * printMenu() prints the menu to be displayed while asking which kind of menu items need to be displayed.
	 */
	public void printMenu()
	{
		int choice;
		Menu menu=null;
		System.out.println("PRINT MENU");
		System.out.println("1. Desserts");
		System.out.println("2. Main course items");
		System.out.println("3. Drinks");
		System.out.println("4. Set Packages");
		System.out.println("5. Go back to the home screen");
		System.out.print("Enter your choice: ");
		choice=sc.nextInt();
		while(choice>=1 && choice<=4)
		{
			switch(choice)
			{
				case 1: menu=new Menu();
						menu.readDessertData();
						menu.printDesserts();
						System.out.println("PRINT MENU");
						System.out.println("1. Desserts");
						System.out.println("2. Main course items");
						System.out.println("3. Drinks");
						System.out.println("4. Set Packages");
						System.out.println("5. Go back to the home screen");
						break;
				case 2: menu=new Menu();
						menu.readMainCourseData();
						menu.printMainCourse();
						System.out.println("PRINT MENU");
						System.out.println("1. Desserts");
						System.out.println("2. Main course items");
						System.out.println("3. Drinks");
						System.out.println("4. Set Packages");
						System.out.println("5. Go back to the home screen");
						break;
				case 3: menu=new Menu();
						menu.readDrinkData();
						menu.printDrinks();
						System.out.println("PRINT MENU");
						System.out.println("1. Desserts");
						System.out.println("2. Main course items");
						System.out.println("3. Drinks");
						System.out.println("4. Set Packages");
						System.out.println("5. Go back to the home screen");
						break;
				case 4: menu=new Menu();
						menu.readSetPackageData();
						menu.printSetPackages();
						System.out.println("PRINT MENU");
						System.out.println("1. Desserts");
						System.out.println("2. Main course items");
						System.out.println("3. Drinks");
						System.out.println("4. Set Packages");
						System.out.println("5. Go back to the home screen");
						break;
			}
			System.out.print("Enter your choice again: ");
			choice=sc.nextInt();
		}		
		System.out.println();
		printHomeScreen();
	}
	/**
	 * updateMenu() prints the menu to be displayed while asking which kind of menu items need to be displayed.
	 * @throws IOException
	 */
	public void updateMenu() throws IOException
	{
		int choice;
		Menu menu;
		System.out.println("UPDATE MENU");
		System.out.println("1. Add dessert");
		System.out.println("2. Add main course item");
		System.out.println("3. Add drink");
		System.out.println("4. Add set package");
		System.out.println("5. Remove dessert");
		System.out.println("6. Remove main course item");
		System.out.println("7. Remove drink");
		System.out.println("8. Remove set package");
		System.out.println("9. Edit dessert details");
		System.out.println("10. Edit main course item details");
		System.out.println("11. Edit drink details");
		System.out.println("12. Edit set package details");
		System.out.println("13. Go back to the home screen");
		System.out.print("Enter your choice: ");
		choice=sc.nextInt();
		while(choice>=1 && choice<=12)
		{
			switch(choice)
			{
				case 1: menu=new Menu();
						menu.readDessertData();
						menu.addDessert();break;
				case 2: menu=new Menu();
						menu.readMainCourseData();
						menu.addMainCourseItem();break;
				case 3: menu=new Menu();
						menu.readDrinkData();
						menu.addDrink();break;
				case 4: menu=new Menu();
						menu.readSetPackageData();
						menu.addSetPackage();break;
				case 5: clearDessert(0);break;
				case 6: clearMainCourse(0);break;
				case 7: clearDrink(0);break;
				case 8: clearSetPackage(0);break;
				case 9: clearDessert(1);break;
				case 10: clearMainCourse(1);break;
				case 11: clearDrink(1);break;
				case 12: clearSetPackage(1);break;
			}
			System.out.print("Enter your choice again: ");
			choice=sc.nextInt();
		}		
		System.out.println("Going back to home screen..");
		printHomeScreen();
	}
	/**
	 * main() controls the whole program
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException 
	{
		Application app=new Application();
		ReservationFile resF=null;
		resF=new ReservationFile(null, 0, 0, 0);
		Restaurant rest=new Restaurant();
		int choice, size, tableNo, contactNo, tableNoReserved=0, contactNoReserved=0, sizeReserved=0;
		boolean finalise=false, member=false, reserved=false, ordered=false, resFound=false, allOccupied=false;
		String name, nameReserved=null;
		Date dateReserved=null;
		printHomeScreen();
		System.out.print("Enter your choice: ");
		choice=sc.nextInt();
		float disc;
		while(choice>=1 && choice<=17)
		{
			tableNo=resF.returnTableID();
			switch(choice)
			{
				case 1: app.printMenu();break;
				case 2: app.updateMenu();break;
				case 3: staF=new StaffFile();
						staF.addStaff();break;
				case 4: staF=new StaffFile();
						staF.readStaffData();
						staF.printStaffData();break;
				case 5: memF=new MemberFile();
						memF.addMember();break;
				case 6: memF=new MemberFile();
						memF.readMemberData();
						memF.printMemberData();break;
				case 7: if(!allOccupied)
						{	
							if(reserved && !finalise)
							{
								disc=(float)0.05;
								if(!ordered)
								{
									ordF=new OrderFile(nameReserved, tableNoReserved, contactNoReserved, resF.returnSize(), null, disc);
									ordF.createOrder(ordered);
									ordered=true;
								}
								else
									ordF.createOrder(ordered);
								tableNo=ordF.returnTableID();
								printHomeScreen();
							}
							if(!reserved && !ordered && !finalise)
							{
								System.out.print("Enter a table size, from 2 to 10: ");
								size=sc.nextInt();
								checkReservation(resF, size); 
								int start=(((size+1)/2)*2-2)*2;
								int end=start+3;
								rest=resF.returnRestaurantDetails();
								System.out.print("Enter the table no: ");
								tableNo=sc.nextInt();
								do
								{
									if((tableNo-1)<start || (tableNo-1)>end)
									{
										System.out.print("Please enter the correct table no.: ");
										tableNo=sc.nextInt();
									}
								}while((tableNo-1)<start || (tableNo-1)>end);
								if(rest.book(tableNo))
									System.out.println("Table "+ tableNo +" is empty. Please get seated.");
								else
								{
									System.out.println("Table "+ tableNo +" is already booked! Please look for another table.");
									break;
								}
								System.out.print("Enter customer name: ");
								name=brStream.readLine();
								System.out.print("Enter customer contact no: ");
								contactNo=sc.nextInt();
								ordF=new OrderFile(name, tableNo, contactNo, size, null, 0);
								ordF.createOrder(ordered);
								ordered=true;
								reserved=true;
								printHomeScreen();
							}
							if(finalise)
								System.out.println("Order already finalised. It can not be changed now.\n");
						}
						else
						{
							System.out.println("All tables are occupied! Check in with your reservation if you have one already!");
							break;
						}
						break;
				case 8: ordF.printOrder();break;
				case 9: if(finalise)
							System.out.println("Order already finalised. It can not be changed now.\n");
						else
						{
							if(ordF.returnCount()>0)
								ordF.removeOrder();
							else
								System.out.println("Order does not exist.");
						}
						break;
				case 10:if(ordF.returnCount()==0)
		        			System.out.println("Order does not exist.");
						else
						{
							if(!finalise)
							{
								finalise=true;
								ordF.dataToFile();
								System.out.println("Order finalised. Thank You.");
							}
							else
								System.out.println("Order was already finalised. Thank You.");	
						}
						break;
				case 11:allOccupied=checkAllReservations(resF);
						if(!allOccupied)
						{
							Date date=new Date();
							member=resF.addReservation(date);
							tableNo=resF.returnTableID();
						}
						else
						{
							System.out.println("All tables are currently occupied. Wait until a table is set free again!");
						}
						break;
				case 12:resF.dataTransferFromFile();
						System.out.print("Enter a name to check reservation under: ");
						name=brStream.readLine();
						for(int i=0;i<resF.returnNumOfReservation();i++)
						{
							if(!resF.returnReservationInfo()[i].returnAvailiability() && !resFound)
							{
								if(name.equalsIgnoreCase(resF.returnReservationInfo()[i].returnName()))
								{
									System.out.println("Reservation exists under the name of "+ resF.returnReservationInfo()[i].returnName());
									System.out.println("Checked in. Please proceed to order.");
									nameReserved=name;
									tableNoReserved=resF.returnReservationInfo()[i].returnTableID();
									contactNoReserved=resF.returnReservationInfo()[i].returnContactNo();
									sizeReserved=resF.returnReservationInfo()[i].returnSize();
									dateReserved=resF.returnReservationInfo()[i].returnDate();
									resFound=true;
									reserved=true;
								}
							}
						}
						if(!resFound)
							System.out.println("No reservation exists currently under the name of "+name);
						resFound=false;
						break;
				case 13:boolean resRemove=false;
						resF.dataTransferFromFile();
						System.out.print("Enter a name to remove a reservation under: ");
						name=brStream.readLine();
						for(int i=0;i<resF.returnNumOfReservation();i++)
						{
							if(!resF.returnReservationInfo()[i].returnAvailiability() && !resRemove)
							{	
								if(name.equalsIgnoreCase(resF.returnReservationInfo()[i].returnName()))
								{
									System.out.println("Removing reservation under the name of "+ resF.returnReservationInfo()[i].returnName());
									resF.returnReservationInfo()[i].setAvailability(true);
									resRemove=true;
								}
							}
						}
						if(!resRemove)
							System.out.println("No reservation exists currently under the name of "+name);
						else
						{	
							clearReservation();
							resF.removeReservationRewrite();
							resF.dataTransferFromFile();
						}
						resRemove=false;
						break;
				case 14:System.out.print("Enter a table size: ");
						size=sc.nextInt();
						checkReservation(resF, size);
						break;
				case 15:allOccupied=checkAllReservations(resF);
						break;
				case 16:resFound=false;
						if(finalise)
						{
							ordF.printOrderInvoice();
							tableNo=ordF.returnOrder().returnTableID();
							resF.dataTransferFromFile();
							if(reserved)
							{
								for(int i=0;i<resF.returnNumOfReservation();i++)
								{
									if(nameReserved.equalsIgnoreCase(resF.returnReservationInfo()[i].returnName()) && !resFound)
									{
										if(!resF.returnReservationInfo()[i].returnAvailiability())
										{
											System.out.println("\n\nRemoving reservation under the name of "+ nameReserved);
											resF.returnReservationInfo()[i].name=nameReserved;
											resF.returnReservationInfo()[i].size=sizeReserved;
											resF.returnReservationInfo()[i].contactNo=contactNoReserved;
											resF.returnReservationInfo()[i].available=true;
											resF.returnReservationInfo()[i].date=dateReserved;
											resFound=true;
										}
									}
								}
								clearReservation();
								resF.removeReservationRewrite();
								resFound=false;
							}
							reserved=false;
							finalise=false;
							ordered=false;
							member=false;
						}
						else
							System.out.println("Order does not exist or it has not been finalised yet. Please order or finalise if an order is already placed.");
						break;
				case 17:SalesReport sr=new SalesReport();
						sr.generateReport();
						break;
				case 18:resF.dataTransferFromFile();
						resF.printData();
						break;
			}
			System.out.print("\nEnter your choice again: ");
			choice=sc.nextInt();
		}
		removeReservation(resF);
		System.out.println("Program terminating..");
	}
}

