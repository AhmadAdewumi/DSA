package leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public int romanToInt(String s){
        Map<Character, Integer> romanToIntMap = new HashMap<>();

        romanToIntMap.put('I', 1);
        romanToIntMap.put('V', 5);
        romanToIntMap.put('X', 10);
        romanToIntMap.put('L', 50);
        romanToIntMap.put('C', 100);
        romanToIntMap.put('D', 500);
        romanToIntMap.put('M', 1000);

        /** -- considering VI and IV (roman are written from largest to smallest
         * Rules:
         * -- on a normal day, for VI we add, since the preceding number is greater than the number ahead
         * -- for IV, the coming number is greater than the preceding one, so we subtract  I from V
         */
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int current = romanToIntMap.get(s.charAt(i));

            /**
             * If we haven't reached the end of the array
             * if the number ahead is greater than the currrent one, we subtract, else we add
             */
            if (i < s.length() -1 && current < romanToIntMap.get(s.charAt(i+1))){
                result = result - current;
            } else {
                result = result + current;
            }
        }

        return result;
    }
}
