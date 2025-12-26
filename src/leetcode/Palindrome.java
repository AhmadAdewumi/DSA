package leetcode;

public class Palindrome {
    public boolean isPalindromeReverseHalf(int x){
        /**
         * -- A negative number cannot be a palindrome (if x < 0)
         * -- A number divisible by 10 is not a palindrome.
         * -- (x % 10 ==0 && x != 0)  -- to check if it is not a multiple of 10 and the number is not zero itself
         */
        if (x < 0 || (x % 10 ==0 && x != 0)){
            return false;
        }

        /**
         * -- we revert the number up to half, and compare the revered half with the original half that remains
         */
        int reverted_number = 0;
        while (x > reverted_number){
            //-- the 10 multiplied give way to another place (tens or hundreds or thousands)
            reverted_number = reverted_number * 10 + x % 10; //-- takes the last digit of x and attaches it to the end of reverted_nuber

            x = x / 10;
        }

        return x == reverted_number || x == reverted_number/10;
    }

    public boolean isPalindromeReverseAll(int x){
        if (x < 0){
            return false;
        }

        int original = x, reversed = 0;
        while (x != 0){
            //-- reversing mathematically
            reversed = reversed * 10 + x % 10;
            x= x/10;
        }

        return original == reversed;
    }
}
