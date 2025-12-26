package arrays;

import java.util.Arrays;

public class ArraySwapping {
    public static void main(String[] args) {
        int[] myList = {10,20,30,40,50,60};
//        int temp = myList[0];
        System.out.println("list length: "+myList.length);
        Arrays.stream(myList).forEach(System.out::println);
        System.out.println("shifted ones");
        for (int i = 0; i < myList.length/2; i++) {
            int temp = myList[i];
            myList[i]=myList[myList.length-1-(i)];
            myList[myList.length-1-(i)]=temp;
        }
        Arrays.stream(myList).forEach(System.out::println);
    }
}