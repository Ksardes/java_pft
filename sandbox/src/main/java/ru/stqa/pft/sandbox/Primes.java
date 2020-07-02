package ru.stqa.pft.sandbox;

public class Primes {

  public static boolean isPrime(int n) {
    int m = (int) Math.sqrt(n);
    for (int i = 2; i < m; i ++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPrime2(int n) {
    for (long i = 2; i < n; i ++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
}
