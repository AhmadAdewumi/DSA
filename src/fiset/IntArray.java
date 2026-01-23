package fiset;

import java.util.Arrays;
import java.util.Iterator;

public class IntArray implements Iterable<Integer> {
    private static final int DEFAULT_CAP = 1 << 3; //-- --> 2^3, bitwise shift to the left 3 times

    public int[] arr; //-- fixed sized array, replaced when resizing
    public int len = 0; //-- number of actual elements (made public, to avoid the overhead the overhead of calling get(i))
    private int capacity = 0; //-- size of the array (users should never touch capacity)

    public IntArray() {
        this(DEFAULT_CAP);
    }

    //-- init array with default capacity
    public IntArray(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Illegal capacity: " + capacity);
        this.capacity = capacity;
        arr = new int[capacity];
    }

    //-- takes an array and make it a dynamic array
    public IntArray(int[] array) {
        if (array == null) throw new IllegalArgumentException("Array cannot be null");
        arr = Arrays.copyOf(array, array.length); //-- no arr = array -- to avoid 'aliasing'
        capacity = len = array.length; //-- capacity = array.length and len = array.length
    }

    //-- returns the size of the array
    public int size() {
        return len;
    }

    public int get(int index) {
        return arr[index];
    }

    //-- returns true or false depending on whether the array is empty
    public boolean isEmpty() {
        return len == 0;
    }

    //-- adds an element to the dynamic array and increment capacity whe necessary
    public void add(int elem) {
        if (len + 1 >= capacity) {
            if (capacity == 0) capacity = 1;
            else capacity *= 2;
            arr = Arrays.copyOf(arr, capacity); //-- extra space is padded with 0
        }
        arr[len++] = elem;
    }

    //-- removes an element at a specified index
    public void removeAt(int removeIndex) {
        System.arraycopy(arr, removeIndex + 1, arr, removeIndex, len - removeIndex - 1);
        --len;
        --capacity;
    }

    //-- search and retrieve an element if it is present in the array
    public boolean remove(int elem) {
        for (int i = 0; i < len; i++) {
            if (arr[i] == elem) {
                removeAt(i);
                return true;
            }
        }

        return false;
    }

    //-- reverse the content of the array
    public void reverse() {
        for (int i = 0; i < len / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[len - i - 1];
            arr[len - i - 1] = temp;
        }
    }

    //-- performs a binary search on this array to find an element in O(log(n)) times
    //-- ensure the array is sorted, if item is not found it returns  a value < 0
    public int binarySearch(int key) {
        int index = Arrays.binarySearch(arr, 0, len, key);
        if (index < 0) index = -index - 1; //-- if no found it tells us where to insert
        return index;
    }

    public void sort() {
        Arrays.sort(arr, 0, len);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < len;
            }

            @Override
            public Integer next() {
                return arr[index++];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }


    @Override
    public String toString() {
        if (len == 0) return "[]";
        else {
            StringBuilder sb = new StringBuilder(len).append("[");
            for (int i = 0; i < len - 1; i++) sb.append(arr[i] + ", ");
            return sb.append(arr[len - 1] + "]").toString();
        }
    }

    public static void main(String[] args) {
        IntArray array = new IntArray();
        array.add(3);
        array.add(50);
        array.add(-3);
        array.add(8);

        array.sort();

        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
    }
}
