package striversAtoZ;

public class CountNumbers {
    static int countDigits(int n) {
        int counter = 0;

        while (n > 0) {
            counter++;

            n = n / 10;
        }

        return counter;
    }

    //-- quite dangerous/fragile for float numbers, computers doesn't represent decimals correctly
    static int usingMaths(int n){
        return (int) (Math.log10(n) +1);
    }

    public static void main(String[] args) {
//        int noOfDigits = countDigits(1245678);
        int noOfDigits = usingMaths(1000);
        System.out.println("The number of digits is : " + noOfDigits);
    }
}
