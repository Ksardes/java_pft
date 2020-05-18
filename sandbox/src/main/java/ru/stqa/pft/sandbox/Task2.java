package ru.stqa.pft.sandbox;

import com.sun.scenario.animation.shared.ClipEnvelope;

import java.sql.SQLOutput;

public class Task2 {

  public static void main(String[] args) {
    Point p1 = new Point(10, 15);
    Point p2 = new Point(4, 4);
    System.out.println("distance between Point p1 and Point p2 = " + distance(p1,p2));
    System.out.println("distance between Point p1 and Point p2 = " + p1.distance(p2));
  }
  public static double distance (Point p1,Point p2) {
    double a = p2.x - p1.x;
    double b = p2.y - p1.y;
    double l = Math.sqrt(a * a + b * b);
    return l;
  }
}
