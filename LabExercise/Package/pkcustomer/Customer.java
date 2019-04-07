package pkcustomer;
import pkaccount.sb.*;
import pkaccount.fd.*;
class Customer{
int cust_id;
String name=" ";
String addr=" ";
SBAccount[] sb;
FDAccount[] fd;
Customer(int a,String b,String c)
{
cust_id=a;
name=name.concat(b);
addr=addr.concat(c);
}
void createaccount(int a)
{
int i=0;
if(a==1)
{
System.out.println("\n\n\tenter account number and balance");
int ac=ac.nextInt();
double bal=bal.nexDouble();
sb[i]=new SBAccount(ac,bal);
i++;
}
else if(a==2)
{
int j=0;
System.out.println("\n\n\tenter account number,deposit amount and period");
int acno=acno.nextInt();
double dep=dep.nextDouble();
int period=period.nextInt();
fd[j]=new FDAccount(acno,period,dep);
j++;
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
