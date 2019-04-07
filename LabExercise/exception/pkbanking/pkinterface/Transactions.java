package pkbanking.pkinterface;
import pkbanking.pkexception.*;
public interface Transactions
{
	double min_bal=500;
	public void withdraw(double a)throws InSufficientFundsException;
	public void deposit(double a);
}