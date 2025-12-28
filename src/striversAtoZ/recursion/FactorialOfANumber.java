package striversAtoZ.recursion;

public class FactorialOfANumber {
    static int factorial(int n){
        if (n == 0){
            return 1;
        }

        return n * factorial((n-1));
    }

    public static void main(String[] args) {
        System.out.println("The factorial of 0 is: " + factorial(5));
    }
}
