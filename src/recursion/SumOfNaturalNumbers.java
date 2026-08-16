package recursion;

public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        int result = sumAllNums(5);
        System.out.println(result);
    }
    public static int sumAllNums(int input){
        if (input == 0) return 0;

        if (input > 0) return input  + sumAllNums(input - 1);

        return sumAllNums(-input);
    }
}
