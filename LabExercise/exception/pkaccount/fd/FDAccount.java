package pkaccount.fd;
import pkaccount.Account;
import pkbanking.pkinterface.InterestRates;
public class FDAccount extends Account implements InterestRates
{
	int period;
	public FDAccount(int a, double b, int p)
	{
		super(a,b);
		period=p;
	}
	public double calc_interest()
	{
		double x;
		x=balance * fdrate * period;
		return x;
	
	}
	public double close()
	{
		double x;
		x = calc_interest();
		balance += x;
		System.out.println("interest"+x);
		//System.out.println("balance after including interest"+balance);
		return balance;
	}
	public void display()
	{
		System.out.println("Account Number:"+accno+ "Balance:"+ balance);
	}
}