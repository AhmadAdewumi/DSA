package striversAtoZ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DivisorsOfANumber {

    static List<Integer> divisors(int num) {
        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                divisors.add(i);

                /**
                 * -- every divisor exists in pair, say num = 36, 4 is a divisor, then, 36/4 = 9 is a divisor also
                 */
                if ((num / i) != i) {
                    divisors.add(num / i);
                }
            }
        }

        //-- sort in ascending order
        Collections.sort(divisors);

        return divisors;
    }

    public static void main(String[] args) {
        System.out.println("The sorted divisors are: " + divisors(49));
    }
}
