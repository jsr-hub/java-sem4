import java.util.Scanner;
class Account
{
	protected int accountnumber;
	protected double balance;
	Account(int t,double b)
	{
		accountnumber=t;
		balance = b;
		
	}
}
class SBAccount extends Account
{
	Scanner sc=new Scanner(System.in);
	SBAccount (int accnum, double init_balance)
	{
		super(accnum,init_balance);		
	}
	double deposit(double amount)
	{
		
		if(amount>0)
			balance += amount;
		return balance;
		//System.out.println("The balance amount after deposit is:"+balance);
	}
	double withdraw(double amount)
	{
		
		if(amount>1000)
		{
		balance -= amount;
		return balance;
		//System.out.println("The balance amount after withdraw is:"+balance);
		}
		else
		{
			System.out.println("Very low balance");
			return 0;
		}
	}
	double calc_interest()
	{
		balance += (balance * 0.04);
		//System.out.println("Interest for the account is:"+balance);
		return balance;
	}
}
class FDAccount extends Account
{
	int year;
	FDAccount (int accnum, double init_balance, int period)
	{
	super(accnum,init_balance);
	year=period;	
	//year=1;
	}	
	double calc_interest()
	{
		balance += (balance * year * 8.25);
		//System.out.println("Interest for the account is:"+balance);
		return balance;
	}
	void close()
	{
		balance += calc_interest();
		System.out.println("Interest after closing:"+balance);
	}
}
class Customer 
{
	int cust_id;
	String name;
	String address;
	SBAccount sba;
	FDAccount fda;
	Scanner sc=new Scanner(System.in);
	Customer(int cid, String cname, String caddress)
	{
		cust_id = cid;
		name=cname;
		address=caddress;
	}
	void createAccount(int a)
	{
		if (a==1)
		{
			System.out.println("Enter Account number and balance");
			int accnum=sc.nextInt();
			double init_balance=sc.nextDouble();
			sba=new SBAccount(accnum,init_balance);
			
		}
		else if(a==2)
		{
			System.out.println("Enter account number, period and balance");
			int accnum=sc.nextInt();
			double init_balance=sc.nextDouble();
			int period=sc.nextInt();
			fda = new FDAccount(accnum,init_balance,period);
			
		}
	}
	void transaction(int ch)
	{ 
		
		if(ch==1)
		{
			int ch1=sc.nextInt();
			switch(ch1)
			{
				case 1:
				{
					System.out.println ("Enter amount to deposit");
					double amount=sc.nextDouble();
				System.out.println(sba.deposit(amount));
				break;
				}
				case 2:
				{
					System.out.println ("Enter amount to withdraw");
					double amount=sc.nextDouble();
				System.out.println(sba.withdraw(amount));
				break;
				}
				case 3:
				{
				System.out.println(sba.calc_interest());
				break;
				}
				default: {System.out.println("Invalid option");}
			}
		}
		else if(ch==2)
		{
			int ch1=sc.nextInt();
			switch(ch1)
			{
				case 1:
				{
				fda.calc_interest();
				break;
				}
				case 2:
				{
				fda.close();
				break;
				}
			}
		}
	}
}
public class BankDemo1
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		Customer[] cust;//=new Customer(5);
		cust = new Customer[2];
		for(int i=0;i<2;i++)
		{
			System.out.println("\n\n\tEnter id,name and address of customer "+(i+1));
			int id=sc.nextInt();
			String name=sc.next();
			String addr=sc.next();
			cust[i]=new Customer(id,name,addr);
			System.out.println("\n\n\t1.SB account\n\t2.FD account");
			int ch=sc.nextInt();
			cust[i].createAccount(ch);
				if(ch==1)
				{
					System.out.println ("\n\n Enter minimum amount:");
					double init_balance=sc.nextDouble();
					System.out.println("\n\n\t1.Deposit\n\t2.Withdraw\n\t3.Calculate interest\n\n\tEnter your choice");
					int ch1=sc.nextInt();
					cust[i].transaction(ch1);
				}
				else if(ch==2)
				{
					System.out.println ("\n\n Enter minimum amount:");
					double init_balance=sc.nextDouble();
					System.out.println("\n\n\t1.Calculate interest\n\t2. Close\n\n\tEnter your choice");
					int ch1=sc.nextInt();
					cust[i].transaction(ch1);
				}
		}
		
	}
}