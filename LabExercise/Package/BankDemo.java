import pkcustomer.*;
import customer
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