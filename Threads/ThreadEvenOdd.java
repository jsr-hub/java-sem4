//error
import java.util.*;
import java.io.*;
public class ThreadEvenOdd extends Thread{
int x;
public ThreadEvenOdd(int a) {
	Scanner sc=new Scanner(System.in);
	System.out.print("Enter the number to do calculation:");
	 a=sc.nextInt();
	x=a;
}
public synchronized void printOdd() throws InterruptedException{
for(int i=0;i<x;i=i+1){
if(i%2==1){
this.wait();
}
else{

this.notify();
System.out.println("odd"+" " +i);
}
}

}
public synchronized void printEven() throws InterruptedException{
for(int i=0;i<x;i=i+1){
if(i%2==0){

this.notify();
System.out.println("even"+" "+i);
}
else{
this.wait();
}
}
}
public static void main(String[] args) {
ThreadEvenOdd even=new ThreadEvenOdd(int);
Thread thread=new Thread() {
@Override
public void run() {
try {
even.printOdd();
} catch (InterruptedException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
};

Thread thread1=new Thread() {
@Override
public void run() {
try {
even.printEven();
} catch (InterruptedException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
};
thread.start();
thread1.start();

}
}