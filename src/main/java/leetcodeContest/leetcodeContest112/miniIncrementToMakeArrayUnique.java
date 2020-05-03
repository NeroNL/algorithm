package leetcodeContest.leetcodeContest112;

import java.util.Arrays;


/**
 * Given an array of integers A, a move consists of choosing any A[i], and incrementing it by 1.
 *
 * Return the least number of moves to make every value in A unique.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,2]
 * Output: 1
 * Explanation:  After 1 move, the array could be [1, 2, 3].
 * Example 2:
 *
 * Input: [3,2,1,2,1,7]
 * Output: 6
 * Explanation:  After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
 * It can be shown with 5 or less moves that it is impossible for the array to have all unique values.
 *
 *
 * Note:
 *
 * 0 <= A.length <= 40000
 * 0 <= A[i] < 40000
 */
public class miniIncrementToMakeArrayUnique {


    /**
     * ~ 30ms
     * @param A
     * @return
     */
    public int minIncrementForUnique(int[] A) {
        int ret = 0;
        if (A == null || A.length == 0) {
            return ret;
        }

        Arrays.sort(A);
        int last = A[0];
        for (int i = 1; i < A.length; ++i) {
            if (A[i] <= last) {
                ++last;
                ret += last - A[i];
            } else {
                last = A[i];
            }
        }

        return ret;
    }


    /**
     * ~ 6 ms
     */

    public int solve(int[] A) {
        int[] count = new int[80000];
        for(int num : A) {
            count[num]++;
        }
        int inc = 0;
        for(int i=0; i<count.length-1; i++) {
            if(count[i]>1) {
                int diff = count[i]-1;
                inc += diff;
                count[i+1] += diff;
            }
        }
        return inc;
    }
}
