package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {

  /*
  @Test
  public void testPrime() {
    Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
  }

  @Test
  public void testNonPrime() {
    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE-2));
  }

  @Test
  public void testPrimeLong() {
    long n = Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrime(n));
  }

   */

  @Test
  public void testPrimeTest1() {
    Assert.assertTrue(Primes.isPrime(4));
  }

  @Test
  public void testPrimeTest2() {
      Assert.assertTrue(Primes.isPrime2(4));
  }
}