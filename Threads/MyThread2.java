//return Fact and AddN separately
//error
import java.util.Scanner;
import java.io.*;

class AddN implements Runnable{
    public void run(){
        for(int i=0;i<x;i++) {
			i+=x;
            System.out.println(i);
        }
    }
}

class Fact implements Runnable{
    public void run(){
        for(int i=1;i<=x;i++) {
			i*=x;
           System.out.println(i);
        }
    }
}
public class MyThread2 {
	Scanner sc=new Scanner(System.in);
	System.out.print("Enter the number to do calculation:");
	int x=sc.nextInt();
    public static void main(String[] args) {
		//int x;
		
		
        Runnable r = new Fact();
        Thread t = new Thread(x);
        Runnable r2 = new AddN();
        Thread t2 = new Thread(x);
		
		
		        t.start();
        t2.start();
		
		
		
    }
}

