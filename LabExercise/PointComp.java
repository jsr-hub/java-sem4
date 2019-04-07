//error
import java.util.*;
class Point implements Comparable
{
  private double x;
  private double y;

  public Point()
  { x=y=0;}

  public Point(double a, double b)
  { x=a; y=b; }

  public Point(Point p)
  { x = p.x; y=p.y; }

  public double findDistance(double a, double b)
  { double dist = Math.sqrt((x-a)*(x-a)+(y-b)*(y-b));
    return dist;
  }
  public double findDistance(Point p)
  { 
    double dist = Math.sqrt((p.x-x)*(p.x-x)+(p.y-y)*(p.y-y));
    return dist;
  }
  public String toString()
  {
    return "( " + x + ", " + y + ")";
  }
 public int compareTo(Object p)
  {
     double d1 = findDistance(0,0);
     double d2 = ((Point)p).findDistance(0,0);
     if (d1<d2) return -1;
     else if (d1>d2) return 1;
     else return 0;
  }
public int hashCode()
  {
    return (int)(x+y);
  }  
public boolean equals(Object p)
  {
     Point p1 = (Point)p;
     if ((x == p1.x) && (y == p1.y))
        return true;
     else
        return false;
  }

}
class ComparePoints implements Comparator<Point>
{
   public int compare(Point p1, Point p2)
  {
     return p1.compareTo(p2);
  }
}
public class PointComp
{
  public static void main(String args[])
  {
    Scanner s = new Scanner(System.in);
    int n;
    double x, y;
    Point p;
    HashSet <Point> pset = new HashSet <Point>();
    System.out.print("Enter No. of points : ");
    n = s.nextInt();
    for (int i=0; i<n; i++)
    {
       System.out.print("Enter x value of point - " + i+": ");
       x = s.nextDouble();      
       System.out.print("Enter y value of point - " + i+": ");
       y = s.nextDouble();
       p = new Point(x,y);
       pset.add(p);         
    }
    System.out.println("\nPoints in the Hash Set");
    System.out.println(pset);

    ArrayList<Point> plist = new ArrayList<Point>(pset);
//plist.addAll(pset);
    plist.sort(new ComparePoints());
    System.out.println("\nPoints sorted in the order of their distance from origin");
    System.out.println(plist);

    System.out.println("\nDistance From Origin");
    System.out.println("    Point              Distance");
    Point p1, p2;
    ListIterator<Point> lt=plist.listIterator();
    while (lt.hasNext())
    {  p1 = lt.next();
       double dist = p1.findDistance(0,0);
       System.out.print(p1);
       System.out.println("     " + dist);
    }

    System.out.println("\nDistance between every pair of points");
    System.out.println("    Point1          Point2               Distance");
    ListIterator<Point> lt1=plist.listIterator();
    while (lt1.hasNext())
    {  p1 = lt1.next();
       int j = lt1.nextIndex();
       ListIterator<Point> lt2 = plist.listIterator(j);
       while (lt2.hasNext())
       {
          p2 = lt2.next();   
          double dist = p1.findDistance(p2);
          System.out.print(p1);
          System.out.print("    "+p2);
    	  System.out.println("     " + dist);
      }
    }
  }
}