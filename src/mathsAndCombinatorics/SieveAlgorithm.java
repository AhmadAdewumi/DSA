package mathsAndCombinatorics;

public class SieveAlgorithm {
    public static int[] sieve(int n){
        Boolean[] prime = new Boolean[n+1];
        for (int i = 0; i < n; i++) {
            prime[i] =true;
        }
        prime[0] = prime[1] = false;

        for (int p = 2; p*p <= n ; p++) {
            if (prime[p]){
                for (int i = p*p ; i <= n ; i += p) {
                    prime[i] =false;
                }
            }
        }

        int count =0;
        for (int i = 2; i <= n; i++) {
            if (prime[i]){
                count++;
            }
        }

        int[] result = new int[count];
        int index = 0;
        for (int p = 2; p <= n; p++) {
            if (prime[p])
                result[index++] = p;
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 35;
        int[] res = sieve(n);
        for (int ele : res) {
            System.out.print(ele + " ");
        }
    }

}
