package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");

    double l = 5;
    System.out.println("S " + l + " = " + area(l));

   double a = 5;
   double b = 10;
   System.out.println("S with side " + a + " and "+ b + " = " + area(a,b));
  }

  public static void hello(String somebody) {
    System.out.println("Hello " + somebody);
  }

  public static double area(double l) {
    return l * l;
  }

  public static double area(double a, double b) {
    return a * b;
  }
}