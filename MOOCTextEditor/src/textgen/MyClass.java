package textgen;

public class MyClass
{
  private int a;
  public double b;
  
  public MyClass(int first, double second)
  {
    this.a = first;
    this.b = second;
  }
  public static void main(String[] args)
  {
    MyClass c1 = new MyClass(10, 20.5);
    MyClass c2 = new MyClass(10, 31.5);
    c2 = c1;   
    c1.a = 2;
    System.out.println(c2.a);
    
    int a = 1;
    int b = 2;
    b = a;
    a = 3;
    System.out.println(a + ", " + b);
  }
}