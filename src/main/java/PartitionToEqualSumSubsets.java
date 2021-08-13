import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * Output: True
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 *
 *
 * Note:
 *
 * 1 <= k <= len(nums) <= 16.
 * 0 < nums[i] < 10000.
 */
public class PartitionToEqualSumSubsets {

    static int avg = 0;
    static Map<int[], Boolean> map = new HashMap<>();

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0, n = nums.length;
        Arrays.sort(nums);
        for (int num : nums) {
            sum += num;
        }

        if (sum % k != 0) return false;
        avg = sum / k;
        return helper(nums, new boolean[n], 0, k, 0, avg);
    }

    private static boolean helper(int[] nums, boolean[] visited, int index, int k, int sum, int avg) {
        if (k == 0) return true;
        if (sum == avg) return helper(nums, visited, 0, k-1, 0, avg);

        for (int i = index; i < nums.length; ++i) {
            if (!visited[i] && sum + nums[i] <= avg) {
                visited[i] = true;
                if (helper(nums, visited, i + 1, k, sum + nums[i], avg)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
    }
}
