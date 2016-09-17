package assignment;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Contains the list of staff of the restaurant after reading their data from the Staff information file
 * @author diveshbiyani
 *
 */
public class StaffFile 
{
	/**
	 * Contains the array of objects of class Staff and the number of staffs in the file
	 */
	private int numOfStaff=0;
	Staff[] staffList=new Staff[100];
	private static BufferedReader brStream=new BufferedReader(new InputStreamReader(System.in));
	/**
	 * Returns the data of the staff in the form of an object array.
	 * @return staffList
	 */
	public Staff[] returnStaff()
	{
		return staffList;
	}
	/**
	 * Returns the number of staff in the file.
	 * @return
	 */
	public int returnNumOfStaff()
	{
		return numOfStaff;
	}
	/**
	 * addStaff() adds the details of a new staff into the Staff file by taking inputs from the user.
	 */
	public void addStaff()
	{
		String name;
		String ID;
		String gender;
		String title;
		try
		{
			BufferedWriter bwStream=new BufferedWriter(new FileWriter("Staff.txt", true));
			PrintWriter pwStream=new PrintWriter(bwStream);
			System.out.println("Enter a staff name");
			name=brStream.readLine();
			System.out.println("Enter the employee ID");
			ID=brStream.readLine();
			System.out.println("Enter the gender");
			gender=brStream.readLine();
			System.out.println("Enter the title");
			title=brStream.readLine();
			pwStream.println(ID+"|"+name+"|"+gender+"|"+title);
			numOfStaff++;
			pwStream.close();
		}
		catch(IOException e)
		{
			System.out.println("IO Error!"+ e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}
	}
	/**
	 * Reads the details of a staff from the file onto an array of objects class Staff
	 */
	public void readStaffData()
	{
	    staffList=new Staff[100];
	    String inputLine;
    	String name;
    	String gender;
    	String title;
    	String employeeId;
    	try
	    {
	    	BufferedReader brStream = new BufferedReader(new FileReader("Staff.txt"));
	    	inputLine = brStream.readLine(); 
	    	while(inputLine!=null)
	    	{
	    		if(!inputLine.equalsIgnoreCase(""))
	    		{
	    			StringTokenizer extract = new StringTokenizer(inputLine, "|");
	    			employeeId = extract.nextToken();
	    			name = extract.nextToken();
	    			gender = extract.nextToken();
	    			title = extract.nextToken();
	    			staffList[numOfStaff]= new Staff(name, employeeId, gender, title);
	    			numOfStaff++;
	    		}
	    		inputLine = brStream.readLine(); 
	    	}
	    	brStream.close();
	    }
	    catch(FileNotFoundException e)
	    {
	    	System.out.println( "Error opening the input file!" + e.getMessage());
	    	System.exit(0);	
	    }
	    catch (IOException e) 
	    {
            System.out.println( "IO Error!" + e.getMessage() );
            e.printStackTrace();
            System.exit(0);
        }
	}
	/**
	 * Prints the details of the staff.
	 */
	public void printStaffData()
	{
		if(numOfStaff>0)
		{
			System.out.println("Staff Information");
			System.out.println(String.format("%10s | %30s | %8s | %10s ", "EmployeeID", "Name", "Gender", "Job Title"));
	        for(int i=0;i<numOfStaff;i++)
	        	System.out.println(String.format("%10s | %30s | %8s | %10s ", staffList[i].getEmployeeID(), staffList[i].getName(), staffList[i].getGender() , staffList[i].getJobTitle()));
		}
		else
			System.out.println("No staff information available");
	}
}
