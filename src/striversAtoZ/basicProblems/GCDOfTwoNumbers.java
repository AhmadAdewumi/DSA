package striversAtoZ.basicProblems;

public class GCDOfTwoNumbers {
    public static int findGCD(int n1, int n2) {
        int gcd = Math.max(n1, n2);

        while (gcd > 0) {
            if (n1 % gcd == 0 && n2 % gcd == 0) {
                return gcd;
            }
            gcd--;
        }

        return gcd;
    }

    static int gcdUsingEuclid(int a, int b) {
        if (a == 0) return b; //-- if one number is 00, the gcd is the other number, gcd(0, 8) = 8
        if (b == 0) return a;

        return gcdUsingEuclid(a, b % a);
    }

    static int gcdUsingWhileLoop(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = b % a;
            a = temp;
        }

        return a;
    }

    /**
     * -- NB: (odd - odd = even)
     * -- 3 RULES
     * -- IF BOTH NUMBERS ARE EVEN -- gcd(a,b) = 2 * gcd(a/2, b/2)
     * -- IF ONE IS  EVEN AND ONE IS ODD -- gcd(a, b) = gcd(a/2, b) OR gcd(a, b/2)
     * -- IF BOTH ARE ODD -- gcd(a, b) = gcd(a -b, min(a, b))
     */
    static int gcdUsingSteinAlgorithm(int a, int b) {
        if (a == 0) return b; //-- if one number is 0, the other is the gcd
        if (b == 0) return a;

        int k; //-- saved multiplier

        //-- While both a and b are even, divide both by 2 and count how many times
        for (k = 0; ((a | b) & 1) == 0; ++k) { //-- check both are even, (a & 1) == 0   // even,  (a & 1) == 1   // odd
            a >>= 1; //-- divide by 2 by shifting the bit to the right
            b >>= 1; //-- same here
        }

        //-- divide a by 2 until it is odd
        while ((a & 1) == 0) {
            a >>= 1;
        }

        //-- a is odd from here
        do {
            //-- turn b odd also
            while ((b & 1) == 0) {
                b >>= 1;
            }//-- now both a and  b is odd

            if (a > b) {//-- we make sure a is always the smallest number
                int temp = a;
                a = b;
                b = temp;
            }
            b = b - a; //-- since odd - odd is even, b becomes even here


        } while (b != 0);

        //-- found the core gcd
        //-- but, we still have the 2's we removed earlier, which is stored in our saved multiplier "k"
        //--take the result, and multiply it by 2 for everytime we successfully divided both numbers by 2 at the very start
        //-- mathematically, a * 2^k
        return a << k;
    }

    public static void main(String[] args) {
        System.out.println("The gcd of both number is: " + gcdUsingSteinAlgorithm(24, 28));
    }
}
