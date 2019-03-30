package 亚麻;


import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class NextPermutation {


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public void nextPermutation(int[] nums) {

        int l = -1;
        for (int i = nums.length-2; i >= 0; --i) {
            if (nums[i] < nums[i+1]) {
                l = i;
                break;
            }
        }

        if (l == -1) {
            Arrays.sort(nums);
            return ;
        }

        int r = l+1;
        for (int i = l+1; i < nums.length; ++i) {
            /*
                Notes: nums[i] should be less and equal to nums[r] to get the last position
             */
            if (nums[i] > nums[l] && nums[i] <= nums[r]) {
                r = i;
            }
        }

        swap(nums, l, r);

        ++l;

        r = nums.length-1;
        //System.out.println(l + ", " + r);
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }
}
