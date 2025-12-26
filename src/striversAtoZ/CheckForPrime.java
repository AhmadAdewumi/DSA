package striversAtoZ;

public class CheckForPrime {
    static boolean isPrime(int n) {
        if (n <= 1) return false; //-- 0 and 1 are not prime numbers

        for (int i = 2; i * i <= n; i++) {//-- start from 2 to the sqrt. since all divide by 1
            if (n % i == 0) {//-- if we find a number that divides n completely, it means n is not PRIME
                return false;
            }

        }

        return true; //-- if we find no divisors, it is prime, coz we are not including the number itself there, just upto the sqrt
    }

    public static void main(String[] args) {
        System.out.println("This num is a prime number: " + isPrime(7));
    }
}
