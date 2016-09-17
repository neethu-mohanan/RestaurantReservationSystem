package random;

import java.io.*;
import java.util.Scanner;

public class Balancing 
{
	private static Scanner sc=new Scanner(System.in);
	private static BufferedReader brStream=new BufferedReader(new InputStreamReader(System.in));
	public int balancedDelimiter(String s)
	{
		Stack st=new Stack();
		char ch, check, flag=0;
		for(int i=0;i<s.length();i++)
		{
			ch=s.charAt(i);
			if(ch=='(' || ch=='[' || ch=='<' || ch=='{' || (ch=='"'&& flag==0))
			{
				if(ch=='"')
					flag=1;
				st.push(ch);
			}
			else if(ch==')')
			{
				check=st.pop();
				if(check!='(')
					return 0;					
			}
			else if(ch==']')
			{
				check=st.pop();
				if(check!='[')
					return 0;					
			}
			else if(ch=='}')
			{
				check=st.pop();
				if(check!='{')
					return 0;					
			}
			else if(ch=='>')
			{
				check=st.pop();
				if(check!='<')
					return 0;					
			}
			else if(ch=='"' && flag==1)
			{
				check=st.pop();
				flag=0;
				if(check!='"')
					return 0;					
			}
		}
		if(st.head==null)
			return 1;
		else 
			return 0;
	}
	public static void main(String[] args) throws IOException
	{
		int num;
		String str;
		System.out.print("Enter the number of test cases: ");
		num=sc.nextInt();
		Balancing obj=new Balancing();
		for(int i=1;i<=num;i++)
		{
			System.out.print("Enter the string: ");
			str=brStream.readLine();
			System.out.println(obj.balancedDelimiter(str));
		}
	}
}
