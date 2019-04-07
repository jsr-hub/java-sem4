import java.util.Scanner;
class Account{
protected int accnumber;
protected double balance;
Account(int a,double b)
{
accnumber=a;
balance=b;
}
}
class SBAccount extends Account{
SBAccount(int acno,double init_balance)
{
super(acno,init_balance);
}
void deposit(double x)
{
if(x>0)
balance+=x;
System.out.println("balance after deposit"+balance);
}
void withdraw(double y)
{
if(balance>1000)
{balance-=y;
System.out.println("balance after Withdraw"+balance);
}
else
System.out.println("\n\n\tInsufficient balance");
}
void calc_interest()
{
balance+=balance*0.04;
System.out.println("Calculated Interest is:"+balance);
}
}
class FDAccount extends Account{
int period;
FDAccount(int acno,int p,double dep)
{
super(acno,dep);
period=p;
}
double calc_interest()
{
return balance*period*0.0825;
}
void close()
{
balance+=calc_interest();
System.out.println("Account is successfully closed");
}
}
class Customer{
int cust_id;
int choice, choice1;
String name=" ";
String addr=" ";
Scanner sc=new Scanner(System.in);
SBAccount sb;
FDAccount fd;
Customer(int a,String b,String c)
{
cust_id=a;
name=name.concat(b);
addr=addr.concat(c);
}
void createaccount(int a)
{
if(a==1)
{
System.out.println("\n\n\tenter account number and balance");
int ac=sc.nextInt();
double bal=sc.nextDouble();
sb=new SBAccount(ac,bal);
}
else if(a==2)
{
System.out.println("\n\n\tenter account number,deposit amount and period");
int acno=sc.nextInt();
double dep=sc.nextDouble();
int period=sc.nextInt();
fd=new FDAccount(acno,period,dep);
}
}
void transaction(int a)
{
	int b;
switch(a)
{
case 1:

//int b;
{
	switch(choice)
{
	case 1:
	{
double amt=sc.nextDouble();
	sb.withdraw(amt);
	break;}
case 2:
{
System.out.println("\n\n\tenter amount to be deposited");
double amt=sc.nextDouble();
sb.deposit(amt);
break;
}
case 3:
{
	sb.calc_interest();
	break;
	}
}
}

case 2:
{
	switch(choice1)
	{
		case 1:
		{
			fd.calc_interest();
			break;
		}
		case 2:
		{
			fd.close();
			break;
		}
	}
}
default:{
System.out.println("\n\n\tInvalid choice");
}
}
}
}
public class BankDemo{
public static void main(String args[]){
	Scanner sc=new Scanner(System.in);
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
cust[i].createaccount(ch);
if(ch==1)
{
System.out.println("\n\n\t1.Withdraw\n\t2.Deposit\n\t3.Calculate interest\n\n\tEnter your choice");
int ch1=sc.nextInt();
cust[i].transaction(ch1);
}
else if(ch==2)
{
cust[i].transaction(4);
}
}
}
}