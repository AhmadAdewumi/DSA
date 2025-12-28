package striversAtoZ.recursion;

public class SumOfFirstNNatNumbers {
    static int sumOfNumbers(int n) {
        int total = 0;

        for (int i = 1; i <= n; i++) {
            total = total + i;
        }

        return total;
    }

    static int sunOfNumbersUsingRecursion(int n) {
        if (n == 1) {
            return 1;
        }

        return n + sunOfNumbersUsingRecursion((n - 1));
    }

    static int sumUsingFormula(int n) {
        return (n * (n + 1))/2;
    }

    public static void main(String[] args) {
        System.out.println(sumUsingFormula(5));
    }
}
