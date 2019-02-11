package 亚麻.ArraysAndString;

/**
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length+1];
        int[] right = new int[nums.length+1];

        left[0] = 1;
        right[right.length-1] = 1;

        for (int i = 0; i < nums.length; ++i) {
            left[i+1] = left[i] * nums[i];
            right[nums.length-i-1] = right[nums.length-i] * nums[nums.length-i-1];
        }

        int[] ret = new int[nums.length];
        for (int i = 0; i < ret.length; ++i) {
            ret[i] = left[i] * right[i+1];
        }

        return ret;
    }




    // without extra space

    public int[] productExceptSelf1(int[] nums) {
        if(nums == null || nums.length == 0) return nums;

        int prefix = 1;
        int[] suffix = new int[nums.length];
        suffix[suffix.length-1] = 1;
        for(int i = suffix.length - 2; i >= 0; i--){
            suffix[i] = nums[i+1] * suffix[i+1];
        }

        for(int i = 0; i < nums.length; i++){
            int temp = prefix * nums[i];
            suffix[i] = prefix * suffix[i];
            prefix = temp;
        }

        return suffix;

    }
}
