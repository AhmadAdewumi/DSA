package striversAtoZ.basicProblems;

public class ReverseDigits {
    static int reverseDigits(int n) {
        //-- say we have a number
        //-- we can extract the last digit
        //-- but to cater for places, we multiply by 10
        //-- store it in a var
        //-- edge case if the number has trailing zeroes, we do not include it

        int revNum = 0;

        while (n > 0) {
            int lastDigit = n % 10;

            revNum = revNum * 10 + lastDigit;

            n = n / 10;
        }

        return revNum;
    }

    public static void main(String[] args) {
        System.out.println(reverseDigits(2345));
    }
}
