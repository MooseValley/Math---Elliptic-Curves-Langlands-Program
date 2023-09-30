# Math - Elliptic Curves, Langlands Program

My code to explore / cross check the cauculations and results in this Numberphile video:
* The Langlands Program - Numberphile, Sep 28, 2023, https://www.youtube.com/watch?v=4dyytPboqvE&t=834s


13:54 Eliptic Curves:
* used in cryptography
* a fancy name for equations in 2 variables x and y where
* one variable appears in degree 3 (cube) and the other appears in degree 2 (square).

Example: y^2 + y = x^3 - x^2

y^2 = highest power of y = a square
x^3 - highest power of x = a cube

* What are the solutions for x and y where x and y are both integers ?
* What are the solutions for x and y where x and y are both real numbers ?
* What are the solutions for x and y where x and y are both complex numbers [i = sqrt(-1)] ?
* For complex numbers, the solutions form a torus - like a donut - a Rhieman Surface.

* For this equation, we are interested in solutions for x and y where x and y are both integers and we are modulo a prime number ?
* e.g. 5
* So, x and y are integers are both >= 0 and < 5, and

   (y^2 + y) MOD 5 = (x^3 - x^2) MOD 5

e.g. If the equations yielded this then this would be a solution:  -5 MOD 5 = 20 MOD 5


22:10  the 1st 100 primes.


24:17 Column 3 - the Difference column - is the key column
* It should average around 0
* It appears random / chaotic ...
* Column 3 is where the meat is.
* The Counting Problem for Eliptic Curves.
* Can we derive the Difference in some other way for all primes ??


24:50 The Alternative Solution
* Langlands Program
* Joins the Number Theory branch of mathematics to the Harmonic Analysis / Modular Forms branch of mathematics.
* Joins two completely different and until now completely separate branches of mathematics.
* Uses bridges - or tunnels - between completely separate branches of mathematics.
* Ground breaking !
* A Miracle !
* A solution to infinitely many problems in 1 line.
* Professor does not understand why this works, but they can prove it is correct.
* Hidden depths that might take 100's of years or more to grasp / solve / understand.
* Order / predictability out of chaos !!
* Harmonic Analysis

q x (1-q)^2 x (1-q^11)^2 x (1-q^2)^2 x (1-q^22)^2 x (1-q^3)^2 x (1-q^33)^2 x (1-q^4)^2 x (1-q^44)^2 ....
<br>= q - 2q^2 - q^3 + 2q^4 + q^5 + 2q^6 - 2q^7 - 2q^9 - 2q^10 + q^11 - 2q^12 + 4q^13 ....

If you ook at coefficient of q to the power of 15: q^5  ==> coefficient = 1
<br>then this equals the Difference (column 3) for Prime 5

<pre>
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
</pre>

For Prime 13, look at coefficient of q to the power of 13: 4q^13 ==> coefficient = 4
<br>So this equals the Difference (column 3) for Prime 13 !

Just look at the prime powers of q.

q - 2q^2 - q^3 + 2q^4 + q^5 + 2q^6 - 2q^7 - 2q^9 - 2q^10 + q^11 - 2q^12 + 4q^13 ....

<pre>
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
</pre>

41:30 Dual Elliptic Curve Deterministic RBG (Dual_EC_DRBG)
NIST, NSA
use Elliptic Curve:
<br>   y^2 = x^3 - 3x + b(mod p)

42:00 The prime number:  11579 ......  951


42:40 Modular Form
<br>==> part of Harmonic Analysis

Sin graph repeats every 2 Pi
<br>Same for Cos, Tan ...


Keywords: Elliptic Curves, Counting Problem, Number Theory, Harmonic Analysis, Modular Forms, Galois groups,

