package striversAtoZ.recursion;

public class PrintNameNTimes {
    static void printNameRecursively(int n) {
        if (n <= 0) {
            return;
        }

        System.out.println("Ahmad");
        printNameRecursively(n-1);
    }

    public static void main(String[] args) {
        printNameRecursively(9);
    }
}
