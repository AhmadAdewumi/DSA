package leetcode;

public class IndexOfFirstOccurrence {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int k = needle.length();

        if (k == 0) { //-- find nothing in something, returns 0
            return 0;
        }

        //-- we do not have to loop till the end of haystack,
        //-- we can just loop till the point of first occurrence
        for (int i = 0; i < n - k; i++) {
            //-- for each char in the haystack, we check if the subsequent chars match the needle
            for (int j = 0; j < k; j++) {
                //-- we check if the haystack's current char matches the need;e's current char
                //-- i+j e.g 0+0, 1+0, if found, then 1 + 1, ...
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }

                //-- if the loop completes, it means we found the needle
                if (j == k - 1) {
                    return i;
                }
            }
        }

        //-- if the outeer loop completes, it means the needle is not i the haystack
        return -1;
    }

    public static int strStrUsingKMP(String haystack, String needle) {
        if (needle.isEmpty()) return 0;

        int n = haystack.length();
        int m = needle.length();

        int[] lps = computeLPS(needle);

        int i = 0;
        int j = 0;

        while (i < n) {
            //-- ALl good, we keep walking
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }

            //-- if we reached the end of the needle pattern, that means we succceed
            if (j == m) {
                return i - j;
            }

            //-- if we are still within range and they still do not match
            else if (i < n && haystack.charAt(i) != needle.charAt(j)) {

                if (j != 0) { //-- coz, if j is 0, we need to move i forward nonetheless
                    j = lps[j - 1]; //-- we jump back to prev. safe index
                } else { //-- we move i forward
                    i++;
                }
            }
        }
        return -1; //-- never found
    }

    public static int[] computeLPS(String needle) {
        int m = needle.length(); //-- the length of the pattern

        int[] lps = new int[m]; //-- we init an array to store the lps e.g for leeto ->  [0,1,2,0,0]

        int len = 0;
        int i = 1; //-- i serves as the tracker, we begin at index because lps[0] = 0

        while (i < m) {
            if (needle.charAt(i) == needle.charAt(len)) {
                len++; //-- increment the tracker to move forwawrd
                lps[i] = len; //-- we save the current length at that position maybe 2 for 'ee'
                i++;
            } else if (len != 0) {
                //-- i remains but we move j backward(I see j as the pointer of the pattern)
                //-- we shorten the current length and retry
                len = lps[len - 1];
            }

            //-- if there is still no match, then we move i forward and set the count of that pos. to 0
            else {
                lps[i] = 0;
                i++;
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        String text = "abracadabra";
        String pattern = "cad";

        System.out.println("The substring's first occurrence occurs at index: " + strStrUsingKMP(text, pattern));
    }

}


//int n = haystack.length();
//int k = needle.length();
//
/// /-- first loop -> to loop thru the haystack
//        for(int i = 0; i <= n-k; i++){
//
//        for(int j=0; j < k; j++){
//        if(haystack.charAt(i+j) != needle.charAt(j)){
//        break;
//        }
//
//        //-- if the inner loop completes, it means we found the needle
//        if (j == k-1){
//        return i;
//                }
//                        }
//                        }
//
//                        return -1;