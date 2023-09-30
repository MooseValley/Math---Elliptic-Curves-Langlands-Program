/*
Keywords: Elliptic Curves, Counting Problem, Number Theory, Harmonic Analysis, Modular Forms, Galois groups,


https://youtu.be/4dyytPboqvE?t=834

13:54 Eliptic Curves:
used in cryptography
a fancy name for equations in 2 variables x and y where
one variable appears in degree 3 (cube) and the other appears in degree 2 (square).

Example: y^2 + y = x^3 - x^2

y^2 = highest power of y = a square
x^3 - highest power of x = a cube

What are the solutions for x and y where x and y are both integers ?
What are the solutions for x and y where x and y are both real numbers ?
What are the solutions for x and y where x and y are both complex numbers [i = sqrt(-1)] ?
For complex numbers, the solutions form a torus - like a donut - a Rhieman Surface.

For this equation, we are interested in solutions for x and y where x and y are both integers and we are modulo a prime number ?
e.g. 5
So, x and y are integers are both >= 0 and < 5.
and
   (y^2 + y) MOD 5 = (x^3 - x^2) MOD 5

e.g. If the equations yielded this then this would be a solution:  -5 MOD 5 = 20 MOD 5


22:10  the 1st 100 primes.


24:17 Column 3 - the Difference column - is the key column
It should average around 0
It appears random / chaotic ...
Column 3 is where the meat is.
The Counting Problem for Eliptic Curves.
Can we derive the Difference in some other way for all primes ??


24:50 The Alternative Solution
Langlands Program
Joins the Number Theory branch of mathematics to the Harmonic Analysis / Modular Forms branch of mathematics.
Joins two completely different and until now completely separate branches of mathematics.
Uses bridges - or tunnels - between completely separate branches of mathematics.
Ground breaking !
A Miracle !
A solution to infinitely many problems in 1 line.
Professor does not understand why this works, but they can prove it is correct.
Hidden depths that might take 100's of years or more to grasp / solve / understand.
Order / predictability out of chaos !!
Harmonic Analysis

q x (1-q)^2 x (1-q^11)^2 x (1-q^2)^2 x (1-q^22)^2 x (1-q^3)^2 x (1-q^33)^2 x (1-q^4)^2 x (1-q^44)^2 ....
= q - 2q^2 - q^3 + 2q^4 + q^5 + 2q^6 - 2q^7 - 2q^9 - 2q^10 + q^11 - 2q^12 + 4q^13 ....

If you ook at coefficient of q to the power of 15: q^5  ==> coefficient = 1
then this equals the Difference (column 3) for Prime 5

          Prime    Num Solutions       Difference
---------------  ---------------  ---------------
              2                4               -2
              3                4               -1
              5                4                1
              7                9               -2
             11               10                1
             13                9                4
             17               19               -2
             19               19                0


For Prime 13, look at coefficient of q to the power of 13: 4q^13 ==> coefficient = 4
So this equals the Difference (column 3) for Prime 13 !

Just look at the prime powers of q.

q - 2q^2 - q^3 + 2q^4 + q^5 + 2q^6 - 2q^7 - 2q^9 - 2q^10 + q^11 - 2q^12 + 4q^13 ....

                        Coefficient =
Coefficients   Prime    Difference  = a(p) = p - Num Solutions for p = p - #sol(p)
------------   -----    --------------
b(2)            q^2         -2
b(3)            q^3         -1
b(5)            q^5         1
b(7)            q^7         -2
b(11)           q^11        1
b(13)           q^13        4
:::


41:30 Dual Elliptic Curve Deterministic RBG (Dual_EC_DRBG)
NIST, NSA
Uses Elliptic Curve:
   y^2 = x^3 - 3x + b(mod p)
42:00 The prime number:  11579 ......  951


42:40 Modular Form
==> part of Harmonic Analysis

Sin graph repeats every 2 Pi
Same for Cos, Tan ...

*/

public class ElipticCurves
{

   public static boolean isPrime (int val)
   {
      boolean result = false; // assume false.

      if (val <= 1)
         result = false;
      if ((val == 2) || (val == 3) )
         result = true;
      else
      {
         result = true;

         for (int k = 3; k < val / 2; k = k + 2)
         {
            if (val % k == 0)
            {
               result = false;
               k = val; // Exit loop
            }
         }
      }

      return result;
   }
   public static boolean elipticCurveEquation1 (int prime, int x, int y, boolean displayResult)
   {
      // Ref: 18:30 in video: https://www.youtube.com/watch?v=4dyytPboqvE

      // y^2 + y = x^3 - x^2
      int LHS = (y * y + y);
      int RHS = (x * x * x - x * x);

      boolean result = (LHS % prime == RHS % prime);

      if ((result == true) && (displayResult == true) )
      {
         if ((LHS == 0) && (RHS == 0) )
            System.out.println ("x = " + x + ", y = " + y + "  (both sides = 0)");
         else
            System.out.println ("x = " + x + ", y = " + y + "  (LHS = " + LHS + ", RHS = " + RHS + ")");
      }

      return result;
   }

   public static void main(String[] args)
   {
      int prime = 5;   // Must be a Prime Number
      int increment = 1;
      /*
      int modulo = 11;  // Must be a Prime Number
      int modulo = 13;  // Must be a Prime Number
      int modulo = 111; // Must be a Prime Number
      int modulo = 133; // Must be a Prime Number
      */

      System.out.println ("Eliptic Curve: y^2 + y = x^3 - x^2");
      System.out.println ("Both sides modulo: " + prime);

      for (int y = 0; y < prime; y++)
      {
         for (int x = 0; x < prime; x++)
         {
            elipticCurveEquation1 (prime, x, y, true);
         }
      }



      System.out.println ();
      System.out.println ();
      System.out.println (String.format ("%5s",  "Count")         + "  " +
                          String.format ("%15s", "Prime")         + "  " +
                          String.format ("%15s", "Num Solutions") + "  " +
                          String.format ("%15s", "Difference") );

      System.out.println (String.format ("%5s",  "-----")           + "  " +
                          String.format ("%15s", "---------------") + "  " +
                          String.format ("%15s", "---------------") + "  " +
                          String.format ("%15s", "---------------") );

      int primeCount = 0;
      int val = 2;

      while (primeCount < 100) // 1st 100 primes
      {
         int solutionsFound = 0;

         if (isPrime (val) == true)
         {
            primeCount++;
            prime = val;

            for (int y = 0; y < prime; y++)
            {
               for (int x = 0; x < prime; x++)
               {
                  boolean result = elipticCurveEquation1 (prime, x, y, false);

                  if (result == true)
                     solutionsFound++;

               }
            }

            System.out.println (String.format ("%,5d",  primeCount)      + "  " +
                                String.format ("%,15d", prime)           + "  " +
                                String.format ("%,15d", solutionsFound)  + "  " +
                                String.format ("%,15d", (prime - solutionsFound) ) );
         }

         if (prime == 3)
            increment = 2; // Increase increment from 1 to 2 from 3 onwards

         val = val + increment;
      }

      System.out.println ("primeCount = " + primeCount);
      System.out.println ();
   }
}