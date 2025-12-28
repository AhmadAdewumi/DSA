package striversAtoZ.recursion;

public class Print1ToN {
    static void print1ToNUsingRecursion(int current, int n) {
        if (current > n) return;

        System.out.println(current);
        print1ToNUsingRecursion(current + 1, n);
    }

    public static void main(String[] args) {
        print1ToNUsingRecursion(1, 10);
    }
}
