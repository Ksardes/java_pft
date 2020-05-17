package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");

    Square s = new Square(5);
    System.out.println("S " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4,10);
    System.out.println("S with side " + r.a + " and " + r.b + " = " + r.area());
  }

  public static void hello(String somebody) {
    System.out.println("Hello " + somebody);
  }

}