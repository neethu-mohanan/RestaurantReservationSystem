package assignment;

import java.io.*;
import java.util.*;
/**
 * Contains the details of all 4 kinds of menu items, i.e. desserts, main course items, drinks and set packages.
 * The maximum number of each kind of menu item is specified.
 * @author salonigupta
 *
 */
public class Menu
{
	private static Scanner sc=new Scanner(System.in);
	private int numOfDessert;
	private int numOfMainCourse;
	private int numOfDrink;
	private int numOfSetPackage;
	private final int maxNumOfDessert=20;
	private final int maxNumOfMainCourse=30;
	private final int maxNumOfDrink=20;
	private final int maxNumOfSetPackage=10;
	private Dessert [] dessert = new Dessert[maxNumOfDessert];
	private MainCourse [] mainCourse = new MainCourse[maxNumOfMainCourse];
	private Drink [] drink = new Drink[maxNumOfDrink];
	private SetPackage [] setPackage = new SetPackage[maxNumOfSetPackage];
	private static BufferedReader brStream=new BufferedReader(new InputStreamReader(System.in));
	/**
	 * Creates a Menu object with 0 items of each kind.
	 */
	Menu()
	{
		numOfDessert=0;
		numOfMainCourse=0;
		numOfDrink=0;
		numOfSetPackage=0;
	}
	/**
	 * Returns the number of maximum desserts that can exist in the menu.
	 * @return maxNumOfDessert;
	 */
	public int returnMaxNumOfDessert()
	{
		return maxNumOfDessert;
	}
	/**
	 * Returns the number of maximum main course items that can exist in the menu.
	 * @return maxNumOfMainCourse
	 */
	public int returnMaxNumOfMainCourse()
	{
		return maxNumOfMainCourse;
	}
	/**
	 * Returns the number of maximum drinks that can exist in the menu.
	 * @return maxNumOfDrink
	 */
	public int returnMaxNumOfDrink()
	{
		return maxNumOfDrink;
	}
	/**
	 * Returns the number of maximum set packages that can exist in the menu.
	 * @return maxNumOfSetPackage
	 */
	public int returnMaxNumOfSetPackage()
	{
		return maxNumOfSetPackage;
	}
	/**
	 * Returns the number of desserts that actually exist in the menu.
	 * @return maxNumOfDessert
	 */
	public int returnNumOfDessert()
	{
		return numOfDessert;
	}
	/**
	 * Returns the number of main course items that actually exist in the menu.
	 * @return maxNumOfMainCourse
	 */
	public int returnNumOfMainCourse()
	{
		return numOfMainCourse;
	}
	/**
	 * Returns the number of drinks that actually exist in the menu.
	 * @return maxNumOfDrink
	 */
	
	public int returnNumOfDrink()
	{
		return numOfDrink;
	}
	/**
	 * Returns the number of set packages that actually exist in the menu.
	 * @return maxNumOfSetPackage
	 */
	public int returnNumOfSetPackage()
	{
		return numOfSetPackage;
	}
	/**
	 * Returns the details of the dessert items.
	 * @return dessert
	 */
	public Dessert[] returnDessert()
	{
		return this.dessert;
	}
	/**
	 * Returns the details of the main course items.
	 * @return mainCouse
	 */
	public MainCourse[] returnMainCourse()
	{
		return this.mainCourse;
	}
	/**
	 * Returns the details of the drinks.
	 * @return drink
	 */
	public Drink[] returnDrink()
	{
		return this.drink;
	}
	/**
	 * Returns the details of the set packages
	 * @return setPackage
	 */
	public SetPackage[] returnSetPackage()
	{
		return this.setPackage;
	}
	/**
	 * addDessert() writes the details of a new dessert to be added into the menu. 
	 */
	public void addDessert()
	{
		String name;
		String description;
		float price;
		boolean exist;
		if(numOfDessert<maxNumOfDessert)
		{
			try
			{
				BufferedWriter bwStream=new BufferedWriter(new FileWriter("Desserts.txt", true));
				PrintWriter pwStream=new PrintWriter(bwStream);
				System.out.println("Enter a dessert name");
				name=brStream.readLine();
				System.out.println("Enter the description");
				description=brStream.readLine();
				System.out.println("Enter the price");
				price=sc.nextFloat();
				exist=true;
				pwStream.println(name+"|"+description+"|"+exist+"|"+price);
				pwStream.close();
			}
			catch(IOException e)
			{
				System.out.println("IO Error!\n"+e.getMessage());
				e.printStackTrace();
				System.exit(0);
			}
		}
		else
			System.out.println("Number of desserts has reached maximum limit. There can not be more desserts in the menu");
	}
	/**
	 * addMainCourseItem() writes the details of a new main course item to be added into the menu. 
	 */
	public void addMainCourseItem()
	{
		String name;
		String description;
		float price;
		boolean exist;
		if(numOfMainCourse<maxNumOfMainCourse)
		{
			try
			{
				BufferedWriter bwStream=new BufferedWriter(new FileWriter("Main Course Items.txt", true));
				PrintWriter pwStream=new PrintWriter(bwStream);
				System.out.println("Enter a main course item name");
				name=brStream.readLine();
				System.out.println("Enter the description");
				description=brStream.readLine();
				System.out.println("Enter the price");
				price=sc.nextFloat();
				exist=true;
				pwStream.println(name+"|"+description+"|"+exist+"|"+price);
				pwStream.close();
			}
			catch(IOException e)
			{
				System.out.println("IO Error!\n"+e.getMessage());
				e.printStackTrace();
				System.exit(0);
			}
		}
		else
			System.out.println("Number of main course items has reached maximum limit. There can not be more main course items in the menu");
	}
	/**
	 * addDrink() writes the details of a new drink to be added into the menu. 
	 */
	public void addDrink()
	{
		String name;
		String description;
		float price;
		boolean exist;
		if(numOfDrink<maxNumOfDrink)
		{
			try
			{
				BufferedWriter bwStream=new BufferedWriter(new FileWriter("Drinks.txt", true));
				PrintWriter pwStream=new PrintWriter(bwStream);
				System.out.println("Enter a drink name");
				name=brStream.readLine();
				System.out.println("Enter the description");
				description=brStream.readLine();
				System.out.println("Enter the price");
				price=sc.nextFloat();
				exist=true;
				pwStream.println(name+"|"+description+"|"+exist+"|"+price);
				pwStream.close();
			}
			catch(IOException e)
			{
				System.out.println("IO Error!\n"+e.getMessage());
				e.printStackTrace();
				System.exit(0);
			}
		}
		else
			System.out.println("Number of drinks has reached maximum limit. There can not be more drinks in the menu");
	}
	/**
	 * addSetPackage() writes the details of a new set package to be added into the menu. 
	 */
	public void addSetPackage()
	{
		String name;
		String description;
		float price;
		boolean exist;
		if(numOfSetPackage<maxNumOfSetPackage)
		{
			try
			{
				BufferedWriter bwStream=new BufferedWriter(new FileWriter("Packages.txt", true));
				PrintWriter pwStream=new PrintWriter(bwStream);
				System.out.println("Enter a set package name");
				name=brStream.readLine();
				System.out.println("Enter the description");
				description=brStream.readLine();
				System.out.println("Enter the price");
				price=sc.nextFloat();
				exist=true;
				pwStream.println(name+"|"+description+"|"+exist+"|"+price);
				pwStream.close();
			}
			catch(IOException e)
			{
				System.out.println("IO Error!\n"+e.getMessage());
				e.printStackTrace();
				System.exit(0);
			}
		}
		else
			System.out.println("Number of set packages has reached maximum limit. There can not be more set packages in the menu");
	}
	/**
	 * readDessertData() reads the details of desserts from the text file and loads it in an array of objects of class Dessert. 
	 */
	public void readDessertData()
	{
		String name;
		String description;
		float price;
		boolean exist;
		try
	    {
	    	BufferedReader brStream = new BufferedReader(new FileReader("Desserts.txt"));
	    	String inputLine;
	    	int i=0;
	    	inputLine = brStream.readLine(); 
	    	while(inputLine!=null)
	    	{
	    		if(!inputLine.equalsIgnoreCase(""))
	    		{
	    			StringTokenizer extract=new StringTokenizer(inputLine, "|");
	    			name=extract.nextToken();
	    			description=extract.nextToken();
	    			exist=Boolean.parseBoolean(extract.nextToken());
	    			price=Float.parseFloat(extract.nextToken());
	    			if(exist==true)
	    			{
	    				dessert[i]=new Dessert(name, description, exist, price);
	    				i++;
	    				numOfDessert++;
	    			}
	    		}
	    		inputLine = brStream.readLine(); 
	    	}
	    	brStream.close();
	    }
	    catch(FileNotFoundException e)
	    {
	    	System.out.println( "Error opening the input file!\n" + e.getMessage());
	    	System.exit(0);	
	    }
	    catch (IOException e) 
	    {
            System.out.println( "IO Error!\n" + e.getMessage() );
            e.printStackTrace();
            System.exit(0);
        }
	}
	/**
	 * readMainCourseData() reads the details of main course items from the text file and loads it in an array of objects of class MainCourse. 
	 */
	public void readMainCourseData()
	{
		String name;
		String description;
		float price;
		boolean exist;
		try
	    {
	    	BufferedReader brStream = new BufferedReader(new FileReader("Main Course Items.txt"));
	    	String inputLine;
	    	int i=0;
	    	inputLine = brStream.readLine(); 
	    	while(inputLine!=null)
	    	{
	    		if(!inputLine.equalsIgnoreCase(""))
	    		{
	    			StringTokenizer extract=new StringTokenizer(inputLine, "|");
	    			name=extract.nextToken();
	    			description=extract.nextToken();
	    			exist=Boolean.parseBoolean(extract.nextToken());
	    			price=Float.parseFloat(extract.nextToken());
	    			if(exist==true)
	    			{
	    				mainCourse[i]=new MainCourse(name, description, exist, price);
	    				i++;
	    				numOfMainCourse++;
	    			}
	    		}
	    		inputLine = brStream.readLine(); 
	    	}
	    	brStream.close();
	    }
	    catch(FileNotFoundException e)
	    {
	    	System.out.println( "Error opening the input file!\n" + e.getMessage());
	    	System.exit(0);	
	    }
	    catch (IOException e) 
	    {
            System.out.println( "IO Error!\n" + e.getMessage() );
            e.printStackTrace();
            System.exit(0);
        }
	}
	/**
	 * readDrinkData() reads the details of a drink from the text file and loads it in an array of objects of class Drink. 
	 */
	public void readDrinkData()
	{
		String name;
		String description;
		float price;
		boolean exist;
		try
	    {
	    	BufferedReader brStream = new BufferedReader(new FileReader("Drinks.txt"));
	    	String inputLine;
	    	int i=0;
	    	inputLine = brStream.readLine(); 
	    	while(inputLine!=null)
	    	{
	    		if(!inputLine.equalsIgnoreCase(""))
	    		{
	    			StringTokenizer extract=new StringTokenizer(inputLine, "|");
	    			name=extract.nextToken();
	    			description=extract.nextToken();
	    			exist=Boolean.parseBoolean(extract.nextToken());
	    			price=Float.parseFloat(extract.nextToken());
	    			if(exist==true)
	    			{
	    				drink[i]=new Drink(name, description, exist, price);
	    				i++;
	    				numOfDrink++;
	    			}
	    		}
	    		inputLine = brStream.readLine(); 
	    	}
	    	brStream.close();
	    }
	    catch(FileNotFoundException e)
	    {
	    	System.out.println( "Error opening the input file!\n" + e.getMessage());
	    	System.exit(0);	
	    }
	    catch (IOException e) 
	    {
            System.out.println( "IO Error!\n" + e.getMessage() );
            e.printStackTrace();
            System.exit(0);
        }
	}
	/**
	 * readSetPackageData() reads the details of set packages from the text file and loads it in an array of objects of class SetPackage. 
	 */
	public void readSetPackageData()
	{
		String name;
		String description;
		float price;
		boolean exist;
		try
	    {
	    	BufferedReader brStream = new BufferedReader(new FileReader("Packages.txt"));
	    	String inputLine;
	    	int i=0;
	    	inputLine = brStream.readLine(); 
	    	while(inputLine!=null)
	    	{
	    		if(!inputLine.equalsIgnoreCase(""))
	    		{
	    			StringTokenizer extract=new StringTokenizer(inputLine, "|");
	    			name=extract.nextToken();
	    			description=extract.nextToken();
	    			exist=Boolean.parseBoolean(extract.nextToken());
	    			price=Float.parseFloat(extract.nextToken());
	    			if(exist==true)
	    			{
	    				setPackage[i]=new SetPackage(name, description, exist, price);
	    				i++;
	    				numOfSetPackage++;
	    			}
	    		}
	    		inputLine = brStream.readLine(); 
	    	}
	    	brStream.close();
	    }
	    catch(FileNotFoundException e)
	    {
	    	System.out.println( "Error opening the input file!\n" + e.getMessage());
	    	System.exit(0);	
	    }
	    catch (IOException e) 
	    {
            System.out.println( "IO Error!\n" + e.getMessage() );
            e.printStackTrace();
            System.exit(0);
        }
	}
	/**
	 * removeDessert() removes a dessert item from the menu by setting its existence to false inside array of objects of class Dessert. 
	 * @throws IOException
	 */
	public void removeDessert() throws IOException
	{
		String name;
		System.out.println("Enter a dessert name");
		name=brStream.readLine();
		boolean removed=false;
		for(int i=0;i<numOfDessert;i++)
		{
			if(name.equalsIgnoreCase(dessert[i].getName()))
			{
				dessert[i].setExists(false);
				System.out.println(dessert[i].getName()+ " removed successfully.");
				removed=true;
				break;
			}
		}
		for(int i=0;i<numOfDessert;i++)
		{
			try
			{
				BufferedWriter bwStream=new BufferedWriter(new FileWriter("Desserts.txt", true));
				PrintWriter pwStream=new PrintWriter(bwStream);
				if(dessert[i].ifExists())
				{
					pwStream.println(dessert[i].getName()+"|"+dessert[i].getDescription()+"|"+dessert[i].ifExists()+"|"+dessert[i].getPrice());
				}
				pwStream.close();
			}
			catch(IOException e)
			{
				System.out.println("IO Error!\n"+e.getMessage());
				e.printStackTrace();
				System.exit(0);
			}
		}
		if(!removed)
			System.out.println(name+ " not removed successfully.");
	}
	/**
	 * removeMainCourse() removes a main course item from the menu by setting its existence to false inside array of objects of 
	 * class MainCourse. 
	 * @throws IOException
	 */
	public void removeMainCourse() throws IOException
	{
		String name;
		System.out.println("Enter a main course name");
		name=brStream.readLine();
		boolean removed=false;
		for(int i=0;i<numOfMainCourse;i++)
		{
			if(name.equalsIgnoreCase(mainCourse[i].getName()))
			{
				mainCourse[i].setExists(false);
				System.out.println(mainCourse[i].getName()+ " removed successfully.");
				removed=true;
				break;
			}
		}
		for(int i=0;i<numOfMainCourse;i++)
		{
			try
			{
				BufferedWriter bwStream=new BufferedWriter(new FileWriter("Main Course Items.txt", true));
				PrintWriter pwStream=new PrintWriter(bwStream);
				if(mainCourse[i].ifExists())
				{
					pwStream.println(mainCourse[i].getName()+"|"+mainCourse[i].getDescription()+"|"+mainCourse[i].ifExists()+"|"+mainCourse[i].getPrice());
				}
				pwStream.close();
			}
			catch(IOException e)
			{
				System.out.println("IO Error!\n"+e.getMessage());
				e.printStackTrace();
				System.exit(0);
			}
		}
		if(!removed)
			System.out.println(name+ " not removed successfully.");
	}
	/**
	 * removeDrink() removes a drink from the menu by setting its existence to false inside array of objects of Drink.
	 * @throws IOException
	 */
	public void removeDrink() throws IOException
	{
		String name;
		System.out.println("Enter a drink name");
		name=brStream.readLine();
		boolean removed=false;
		for(int i=0;i<numOfDrink;i++)
		{
			if(name.equalsIgnoreCase(drink[i].getName()))
			{
				drink[i].setExists(false);
				System.out.println(drink[i].getName()+ " removed successfully.");
				removed=true;
				break;
			}
		}
		for(int i=0;i<numOfDrink;i++)
		{
			try
			{
				BufferedWriter bwStream=new BufferedWriter(new FileWriter("Drinks.txt", true));
				PrintWriter pwStream=new PrintWriter(bwStream);
				if(drink[i].ifExists())
				{
					pwStream.println(drink[i].getName()+"|"+drink[i].getDescription()+"|"+drink[i].ifExists()+"|"+drink[i].getPrice());
				}
				pwStream.close();
			}
			catch(IOException e)
			{
				System.out.println("IO Error!\n"+e.getMessage());
				e.printStackTrace();
				System.exit(0);
			}
		}
		if(!removed)
			System.out.println(name+ " not removed successfully.");
	}
	/**
	 * removeSetPackage() removes a set package from the menu by setting its existence to false inside array of objects of SetPackage.
	 * @throws IOException
	 */
	public void removeSetPackage() throws IOException
	{
		String name;
		System.out.println("Enter a set package name");
		name=brStream.readLine();
		boolean removed=false;
		for(int i=0;i<numOfSetPackage;i++)
		{
			if(name.equalsIgnoreCase(setPackage[i].getName()))
			{
				setPackage[i].setExists(false);
				System.out.println(setPackage[i].getName()+ " removed successfully.");
				removed=true;
				break;
			}
		}
		for(int i=0;i<numOfSetPackage;i++)
		{
			try
			{
				BufferedWriter bwStream=new BufferedWriter(new FileWriter("Packages.txt", true));
				PrintWriter pwStream=new PrintWriter(bwStream);
				if(setPackage[i].ifExists())
				{
					pwStream.println(setPackage[i].getName()+"|"+setPackage[i].getDescription()+"|"+setPackage[i].ifExists()+"|"+setPackage[i].getPrice());
				}
				pwStream.close();
			}
			catch(IOException e)
			{
				System.out.println("IO Error!\n"+e.getMessage());
				e.printStackTrace();
				System.exit(0);
			}
		}
		if(!removed)
			System.out.println(name+ " not removed successfully.");
	}
	/**
	 * editDessert() edits the details of a dessert by taking input of a dessert name, and asking for new details inside the 
	 * array of objects of Dessert. Now, the updated data is rewritten on the file.
	 * @throws IOException
	 */
	public void editDessert() throws IOException
	{
		String name, description;
		float price;
		boolean exist;
		System.out.println("Enter a dessert name");
		name=brStream.readLine();
		boolean edit=false;
		for(int i=0;i<numOfDessert;i++)
		{
			if(name.equalsIgnoreCase(dessert[i].getName()))
			{
				System.out.println("Enter a new dessert name");
				name=brStream.readLine();
				System.out.println("Enter a new description");
				description=brStream.readLine();
				System.out.println("Enter a new price");
				price=sc.nextFloat();
				exist=true;
				System.out.println(dessert[i].getName()+ " edited successfully.");
				dessert[i].setName(name);
				dessert[i].setDescription(description);
				dessert[i].setExists(exist);
				dessert[i].setPrice(price);
				edit=true;
				break;
			}
		}
		for(int i=0;i<numOfDessert;i++)
		{
			try
			{
				BufferedWriter bwStream=new BufferedWriter(new FileWriter("Desserts.txt", true));
				PrintWriter pwStream=new PrintWriter(bwStream);
				pwStream.println(dessert[i].getName()+"|"+dessert[i].getDescription()+"|"+dessert[i].ifExists()+"|"+dessert[i].getPrice());
				pwStream.close();
			}
			catch(IOException e)
			{
				System.out.println("IO Error!\n"+e.getMessage());
				e.printStackTrace();
				System.exit(0);
			}
		}
		if(!edit)
			System.out.println(name+ " not edited successfully.");
	}
	/**
	 * editMainCourse() edits the details of a main course item by taking input of a main course item name, and 
	 * asking for new details inside the array of objects of MainCourse. Now, the updated data is rewritten on the file.
	 * @throws IOException
	 */
	public void editMainCourse() throws IOException
	{
		String name, description;
		float price;
		boolean exist;
		System.out.println("Enter a main course item name");
		name=brStream.readLine();
		boolean edit=false;
		for(int i=0;i<numOfMainCourse;i++)
		{
			if(name.equalsIgnoreCase(mainCourse[i].getName()))
			{
				System.out.println("Enter a new main course name");
				name=brStream.readLine();
				System.out.println("Enter a new description");
				description=brStream.readLine();
				System.out.println("Enter a new price");
				price=sc.nextFloat();
				exist=true;
				System.out.println(mainCourse[i].getName()+ " edited successfully.");
				mainCourse[i].setName(name);
				mainCourse[i].setDescription(description);
				mainCourse[i].setExists(exist);
				mainCourse[i].setPrice(price);
				edit=true;
				break;
			}
		}
		for(int i=0;i<numOfMainCourse;i++)
		{
			try
			{
				BufferedWriter bwStream=new BufferedWriter(new FileWriter("Main Course Items.txt", true));
				PrintWriter pwStream=new PrintWriter(bwStream);
				pwStream.println(mainCourse[i].getName()+"|"+mainCourse[i].getDescription()+"|"+mainCourse[i].ifExists()+"|"+mainCourse[i].getPrice());
				pwStream.close();
			}
			catch(IOException e)
			{
				System.out.println("IO Error!\n"+e.getMessage());
				e.printStackTrace();
				System.exit(0);
			}
		}
		if(!edit)
			System.out.println(name+ " not edited successfully.");
	}
	/**
	 * editDrink() edits the details of a drink by taking input of a drink name, and asking for new details inside the 
	 * array of objects of Drink. Now, the updated data is rewritten on the file.
	 * @throws IOException
	 */
	public void editDrink() throws IOException
	{
		String name, description;
		float price;
		boolean exist;
		System.out.println("Enter a drink name");
		name=brStream.readLine();
		boolean edit=false;
		for(int i=0;i<numOfDrink;i++)
		{
			if(name.equalsIgnoreCase(drink[i].getName()))
			{
				System.out.println("Enter a new drink name");
				name=brStream.readLine();
				System.out.println("Enter a new description");
				description=brStream.readLine();
				System.out.println("Enter a new price");
				price=sc.nextFloat();
				exist=true;
				System.out.println(drink[i].getName()+ " edited successfully.");
				drink[i].setName(name);
				drink[i].setDescription(description);
				drink[i].setExists(exist);
				drink[i].setPrice(price);
				edit=true;
				break;
			}
		}
		for(int i=0;i<numOfDrink;i++)
		{
			try
			{
				BufferedWriter bwStream=new BufferedWriter(new FileWriter("Drinks.txt", true));
				PrintWriter pwStream=new PrintWriter(bwStream);
				pwStream.println(drink[i].getName()+"|"+drink[i].getDescription()+"|"+drink[i].ifExists()+"|"+drink[i].getPrice());
				pwStream.close();
			}
			catch(IOException e)
			{
				System.out.println("IO Error!\n"+e.getMessage());
				e.printStackTrace();
				System.exit(0);
			}
		}
		if(!edit)
			System.out.println(name+ " not removed successfully.");
	}
	/**
	 * editSetPackage() edits the details of a set package by taking input of a set package name, and asking for new details inside the 
	 * array of objects of SetPackage. Now, the updated data is rewritten on the file.
	 * @throws IOException
	 */
	public void editSetPackage() throws IOException
	{
		String name, description;
		float price;
		boolean exist;
		System.out.println("Enter a set package name");
		name=brStream.readLine();
		boolean edit=false;
		for(int i=0;i<numOfSetPackage;i++)
		{
			if(name.equalsIgnoreCase(setPackage[i].getName()))
			{
				System.out.println("Enter a new set package name");
				name=brStream.readLine();
				System.out.println("Enter a new description");
				description=brStream.readLine();
				System.out.println("Enter a new price");
				price=sc.nextFloat();
				exist=true;
				System.out.println(setPackage[i].getName()+ " edited successfully.");
				setPackage[i].setName(name);
				setPackage[i].setDescription(description);
				setPackage[i].setExists(exist);
				setPackage[i].setPrice(price);
				edit=true;
				break;
			}
		}
		for(int i=0;i<numOfSetPackage;i++)
		{
			try
			{
				BufferedWriter bwStream=new BufferedWriter(new FileWriter("Packages.txt", true));
				PrintWriter pwStream=new PrintWriter(bwStream);
				pwStream.println(setPackage[i].getName()+"|"+setPackage[i].getDescription()+"|"+setPackage[i].ifExists()+"|"+setPackage[i].getPrice());
				pwStream.close();
			}
			catch(IOException e)
			{
				System.out.println("IO Error!\n"+e.getMessage());
				e.printStackTrace();
				System.exit(0);
			}
		}
		if(!edit)
			System.out.println(name+ " not edited successfully.");
	}
	/**
	 * printDesserts() prints the data of all the desserts, if there are any.
	 */
	public void printDesserts()
	{
		if(numOfDessert==0)
		 	System.out.println("Dessert menu does not exist.");
		else
		{
			System.out.println("Desserts");
			System.out.println(String.format("%5s | %27s | %33s | %5s ", "SNo", "Dessert", "Description", "Price"));
			for(int i=0;i<numOfDessert;i++)
			{
				if(dessert[i].ifExists())
					System.out.println(String.format("%5d | %27s | %33s | %.2f ", (i+1), dessert[i].getName(), dessert[i].getDescription(), dessert[i].getPrice()));
			}
		}
	}
	/**
	 * printMainCourse() prints the data of all the main course items, if there are any.
	 */
	public void printMainCourse()
	{
		if(numOfMainCourse==0)
		 	System.out.println("Main Course menu does not exist.");
		else
		{
			System.out.println("Main Course Items");
			System.out.println(String.format("%5s | %27s | %33s | %5s ", "SNo", "Main Course Items", "Description", "Price"));
			for(int i=0;i<numOfMainCourse;i++)
			{
				if(mainCourse[i].ifExists())
					System.out.println(String.format("%5d | %27s | %33s | %.2f ", (i+1), mainCourse[i].getName(), mainCourse[i].getDescription(), mainCourse[i].getPrice()));
			}
		}
	}
	/**
	 * printDrinks() prints the data of all the drinks, if there are any.
	 */
	public void printDrinks()
	{
		if(numOfDrink==0)
		 	System.out.println("Drink menu does not exist.");
		else
		{
			System.out.println("Drinks");
			System.out.println(String.format("%5s | %27s | %33s | %5s ", "SNo", "Drinks", "Description", "Price"));
			for(int i=0;i<numOfDrink;i++)
			{
				if(drink[i].ifExists())
					System.out.println(String.format("%5d | %27s | %33s | %.2f ", (i+1), drink[i].getName(), drink[i].getDescription(), drink[i].getPrice()));
			}
		}
	}
	/**
	 * printSetPackages() prints the data of all the set packages, if there are any.
	 */
	public void printSetPackages()
	{
		if(numOfSetPackage==0)
		 	System.out.println("Set Package menu does not exist.");
		System.out.println("Set Packages");
		System.out.println(String.format("%5s | %27s | %33s | %5s ", "SNo", "Set Packages", "Description", "Price"));
        for(int i=0;i<numOfSetPackage;i++)
        {
        	if(setPackage[i].ifExists())
        		System.out.println(String.format("%5d | %27s | %33s | %.2f ", (i+1), setPackage[i].getName(), setPackage[i].getDescription(), setPackage[i].getPrice()));
        }
	}
}
