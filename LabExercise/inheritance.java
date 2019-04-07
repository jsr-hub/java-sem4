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
}
void withdraw(double y)
{
if(balance>1000)
balance-=y;
else
System.out.println("\n\n\tInsufficient balance");
}
void calc_interest()
{
balance+=balance*0.04;
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
}
}
class Customer{
int cust_id;
String name=" ";
String addr=" ";
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
int ac=ac.nextInt();
double bal=bal.nexDouble();
sb=new SBAccount(ac,bal);
}
else if(a==2)
{
System.out.println("\n\n\tenter account number,deposit amount and period");
int acno=acno.nextInt();
double dep=dep.nextDouble();
int period=period.nextInt();
fd=new FDAccount(acno,period,dep);
}
}
void transaction(int a)
{
switch(a)
{
case 1:{
System.out.println("\n\n\tenter amount to be withdrawn");
double amt=amt.nextDouble();
sb.withdraw(amt);
break;
}
case 2:{
System.out.println("\n\n\tenter amount to be deposited");
double amt=amt.nextDouble();
sb.deposit(amt);
break;
}
case 3:{
sb.calc_interest();
break;
}
case 4:{
fd.close();
break;
}
default:{
System.out.println("\n\n\tInvalid choice");
}
}
}
}
public class BankDemo{
public static void main(String args[]){
Customer[] cust=new Customer(5);
for(int i=0;i<5;i++)
{
System.out.println("\n\n\tEnter id,name and address of customer "+(i+1));
int id=id.nextInt();
String name=name.next();
String addr=addr.next();
cust[i]=new Customer(id,name,addr);
System.out.println("\n\n\t1.SB account\n\t2.FD account");
int ch=ch.nextInt();
cust[i].createaccount(ch);
if(ch==1)
{
System.out.println("\n\n\t1.Withdraw\n\t2.Deposit\n\t3.Calculate interest\n\n\tEnter your choice");
int ch1=ch1.nextInt();
cust[i].transaction(ch1);
}
else if(ch==2)
{
cust[i].transaction(4);
}
}
}
}