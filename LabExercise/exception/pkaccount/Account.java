package pkaccount;
public class Account
{
	protected int accno;
	protected double balance;
	public Account()
	{
		accno=0;
		balance=0.0;
	}
	public Account(int a,double b)
	{
		accno=a;
		balance=b;
	}
}