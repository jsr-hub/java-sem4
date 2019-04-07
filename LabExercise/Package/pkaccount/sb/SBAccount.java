package pkaccount.sb;
import pkbanking.pkinterface.*;
import pkaccount.Account;
public class SBAccount extends Account implements Transaction,InterestRate
{
SBAccount(int acno,double init_balance)
{
super(acno,init_balance);
}
void deposit(double x)
{
if(x>0)
balance+=x;
}
void withdraw(double y)
{
if(balance>min_balance)
balance-=y;
else
System.out.println("\n\n\tInsufficient balance");
}
void calc_interest()
{
balance+=balance*sbrate/100;
}
}