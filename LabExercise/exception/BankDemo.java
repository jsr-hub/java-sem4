import java.util.Scanner;
import pkcustomer.Customer;
public class BankDemo
{
	public static void main(String args[])
	{
		Customer c[]=new Customer[5];
		int r[]=new int[5];
		Scanner sc=new Scanner(System.in);
		for (int i=0;i<5;i++)
		{
			c[i]=new Customer(i,"ABC","Tanjavur");
			System.out.println("Customer"+(i+1));
			System.out.println("Account type <0 for SB/1 for FD");
			int a=sc.nextInt();
			r[i]=a;
			c[i].createaccount(a);
		}
		for(int i=0;i<5;i++)
		{
			System.out.println("Customer"+(i+1));
			if (r[i]==0)
			{
				System.out.println("\nMenu:\n 1.SBDeposit\n 2.SBWithdraw\n3.SBInterest\n choice:");
				int b=sc.nextInt();
				c[i].transaction(b);
			}				
			else
			{
				System.out.println("\nMenu:\n 1.FDClosing\n 2.FDInterst\n choice:");
				int o=sc.nextInt();
				c[i].transaction(4);
			}
		}
	}
}