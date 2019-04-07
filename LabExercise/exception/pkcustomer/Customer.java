package pkcustomer;
import java.util.Scanner;
import pkaccount.sb.*;
import pkaccount.fd.*;
public class Customer
{
	int cust_id;
	String addr, name;
	SBAccount sb;
	FDAccount fd;
	public Customer(int a, String b, String c)
	{
		cust_id = a;
		addr = b;
		name = c;
	}
	public void createaccount(int o)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Account and Balance");
		int m=sc.nextInt();
		double r=sc.nextDouble();
		switch(o)
		{
			case 0:
			System.out.println("Period");
			int p = sc.nextInt();
			fd = new FDAccount(m,r,p);
		}
	}
	public void transaction(int o)
	{
		Scanner sc = new Scanner(System.in);
		switch(o)
		{
			case 1:
			{
				System.out.println("Enter the deposit amount:");
				double a = sc.nextDouble();
				sb.deposit(a);
				sb.display();
			}
			break;
			
			case 2:
			{
				System.out.println("Enter withdrawal amount:");
				double a=sc.nextDouble();
				try
				{
					sb.withdraw(a);
				}catch (Exception e)
				{
					System.out.println(e);
				}
				sb.display();
			}
			break;
			case 3:
			sb.calc_interest();
			break;
			
			case 4:
			{
				fd.close();
				fd.display();
			}
			break;
		}		
	}	
}