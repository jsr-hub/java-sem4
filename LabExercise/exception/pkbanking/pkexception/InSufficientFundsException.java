package pkbanking.pkexception;
public class InSufficientFundsException extends Exception
{
	String desc;
	public InSufficientFundsException()
	{
		desc="Insufficient Funds";
	}
	public InSufficientFundsException(String a)
	{
		desc = a;
	}
	public String toString()
	{
		return ("Exception["+desc+"]");
	}
}