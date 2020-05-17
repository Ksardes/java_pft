package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceTests {
  Point p1 = new Point(5, 10);
  Point p2 = new Point(5, 5);
  Point p3 = new Point(12, 9);
  Point p4 = new Point(11, 15);

  @Test
  public void testDistance1() {
    Assert.assertEquals(p1.distance(p2), 5.0);
  }

  @Test
  public void testDistance2() {
    Assert.assertEquals(p3.distance(p4), 6.082762530298219);
  }

  @Test
  public void testDistance3() {
    Assert.assertEquals(p1.distance(p3), 7.0710678118654755);
  }

  @Test
  public void testDistance4() {
    Assert.assertEquals(p2.distance(p3), 8.06225774829855);
  }
}

