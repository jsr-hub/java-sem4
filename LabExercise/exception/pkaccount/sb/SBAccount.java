package pkaccount.sb;
import pkaccount.Account;
import pkbanking.pkinterface.*;
import pkbanking.pkexception.*;
public class SBAccount extends Account implements Transactions, InterestRates
{
	public SBAccount(int a, double b)
	{
		super(a,b);
	}
	public void deposit(double a)
	{
		try
		{
			if (a<0)
			{
				throw new IllegalArgumentException();
			}
			balance+=a;
		}catch(IllegalArgumentException e)
		{
			System.out.println(e);
		}
	}
	public void withdraw(double a) throws InSufficientFundsException
	{
		//double min_bal;
		InSufficientFundsException f=new InSufficientFundsException();
		try
		{
			if((balance - a)>min_bal)
				balance += a;
			else
				throw f;
		} catch(InSufficientFundsException e)
		{
			System.out.println(e);
		}
	}
	public void calc_interest()
	{
		double interest;
		interest = balance * sbrate;
		balance += interest;
		System.out.println("interest"+interest);
		System.out.println("balance after including interest"+balance);
	}
	public void display()
	{
		System.out.println("Account Number:"+accno+ "Balance:"+ balance);
	}
}