package striversAtoZ.basicProblems;

public class Palindrome {
    static boolean isPalindrome(int n) {
        if (n < 0 || (n % 10 == 0 && n != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (n > revertedNumber) {
            revertedNumber = revertedNumber * 10 + n % 10; //-- build the reverted number by appending remainder
            n = n / 10; //-- strip the last digit
        }

        return n == revertedNumber || n == revertedNumber / 10; //-- second check is for odd no.s case
    }

    public static void main(String[] args) {
        System.out.println("Is the number palindrome? : " + isPalindrome(4774));
    }
}