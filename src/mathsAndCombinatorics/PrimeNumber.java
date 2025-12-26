package mathsAndCombinatorics;

import java.util.Scanner;

public class PrimeNumber {
    public static  boolean isPrime(int n){
        for (int i = 2; i <= Math.sqrt(n) ; i++) {
            if (n % i == 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int n = scanner.nextInt();
        if (isPrime(n)){
            System.out.println("the number: " + n +" is a prime number!");
        }else
            System.out.println("the number: " + n +" is not a prime number!");
    }
}
