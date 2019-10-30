package Amazon.TreeAndGraph;

import common.TreeNode;

/**
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 *
 * The root is the maximum number in the array.
 * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum tree by the given array and output the root node of this tree.
 *
 * Example 1:
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 * Note:
 * The size of the given array will be in the range [1,1000].
 */
public class MaxBST {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }


    public TreeNode helper(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }

        int index = -1, max = Integer.MIN_VALUE;
        for (int i = begin; i <= end; ++i) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        TreeNode node = new TreeNode(nums[index]);
        node.left = helper(nums, begin, index-1);
        node.right = helper(nums, index+1, end);
        return node;
    }
}