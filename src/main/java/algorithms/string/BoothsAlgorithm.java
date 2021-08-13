package algorithms.string;

import java.util.Arrays;

/**
 * This file contains an implementation of Booths algorithm which finds the lexicographically smallest string rotation
 */
public class BoothsAlgorithm {

    /**
     * Performs this algorithm returning the earliest index of the lexicographically smallest string rotation.
     * Note that comparisons are done using ASCII values, so mixing lowercase and uppercase letters may give you
     * unpected results. O(n)
     * @param s
     * @return
     */
    public static int leastCyclicRotation(String s) {
        s += s;
        int n = s.length();
        int[] arr = new int[n];
        Arrays.fill(arr, -1);
        int k = 0;
        for (int j = 1; j < n; ++j) {
            char sj = s.charAt(j);
            int i = arr[j-k-1];
            while(i != -1 && sj != s.charAt(k+i+1)) {
                if (sj < s.charAt(k+i+1)) k = j-i-1;
                i = arr[i];
            }

            if (sj != s.charAt(k+i+1)) {
                if (sj < s.charAt(k)) k = j;
                arr[j-k] = -1;
            } else {
                arr[j-k] = i+1;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        String s = "abcde";
        System.out.println(leastCyclicRotation(s));
        s = "cdeab";
        System.out.println(leastCyclicRotation(s));
    }
}
