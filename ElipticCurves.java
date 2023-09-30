/*
Keywords: Elliptic Curves, Counting Problem, Number Theory, Harmonic Analysis, Modular Forms, Galois groups,

My code to explore / cross check the cauculations and results in this Numberphile video:
* The Langlands Program - Numberphile, Sep 28, 2023, https://www.youtube.com/watch?v=4dyytPboqvE&t=834s

For more information, see README.MD

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