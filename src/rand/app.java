package rand;

import java.util.Scanner;

public class app 
{
	private static Scanner sc=new Scanner(System.in);
	int a[]=new int[10];
	public void input()
	{
		for(int i=0;i<10;i++)
			a[i]=sc.nextInt();
	}
	public int findShortest(int first, int last)
	{
		int mid=(first+last)/2;
		if(a[mid+1]<a[mid])
			return a[mid+1];
		else
		{
			if(a[first]<a[mid])
				return findShortest(mid+1, last);
			else
				return findShortest(first, mid);
		}
	}
	public static void main(String[] args) 
	{
		app obj=new app();
		System.out.println("Enter array in cyclic order:");
		obj.input();
		System.out.println("Smallest in array: " + obj.findShortest(0,9));
	}

}
