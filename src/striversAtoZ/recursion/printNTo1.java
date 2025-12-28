package striversAtoZ.recursion;

public class printNTo1 {
    static void printNTo1UsingRecursion(int n) {
        if (n <= 0) {
            return;
        }

        System.out.println(n);
        printNTo1UsingRecursion(n - 1);
    }

    public static void main(String[] args) {
        printNTo1UsingRecursion(10);
    }

}
