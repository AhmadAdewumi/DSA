package striversAtoZ;

public class ArmstrongNumber {
    public static boolean isArmstrong(int num) {
        int originalNum = num;
        int totalAfterTakingExponent = 0;

        String numStr = String.valueOf(num);
        int numLen = numStr.length();

        int[] numsArr = new int[numLen];

        for (int i = 0; i < numLen; i++) {
            numsArr[i] = num % 10; //-- the numbers will be stored in reverse, but we do not really care since we will be adding all
            totalAfterTakingExponent += (int) Math.pow(numsArr[i], numLen);

//            System.out.println("The total number when raised to power is: " + totalAfterTakingExponent);

            num = num / 10;
        }

        if (totalAfterTakingExponent == originalNum) {
            return true;
        }

        return false;

    }

    public static void main(String[] args) {
        System.out.println("Is this Armstrong?: " + isArmstrong(153));
    }
}
