package recursion;

public class DecimalToBinary {
    public static void main(String[] args){
        String binary = decToBin(233, "");
    }

    public static String decToBin(int decimal, String result){
        if (decimal == 0) return result;

        result = decimal % 2 + result;
        return decToBin(decimal/2, result);
    }
}
