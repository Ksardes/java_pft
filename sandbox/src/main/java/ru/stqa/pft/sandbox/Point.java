package ru.stqa.pft.sandbox;

public class Point {
  public double x;
  public double y;

  public Point(double x,double y){
    this.x = x;
    this.y = y;
  }
  public double distance (Point p) {
    double a = this.x - p.x;
    double b = this.y - p.y;
    double l = Math.sqrt(a * a + b * b);
    return l;
  }
}
