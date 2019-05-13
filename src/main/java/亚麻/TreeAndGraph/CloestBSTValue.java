package 亚麻.TreeAndGraph;

import common.TreeNode;

/**
 * Given a non-empty binary search tree and a target value, findWithDuplicates the value in the BST that is closest to the target.
 *
 * Note:
 *
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 * Example:
 *
 * Input: root = [4,2,5,1,3], target = 3.714286
 *
 *     4
 *    / \
 *   2   5
 *  / \
 * 1   3
 *
 * Output: 4
 */
public class CloestBSTValue {
    public int closestValue(TreeNode root, double target) {
        int ans = root.val;

        TreeNode node = root;

        while (node != null) {
            if (Math.abs(target - node.val) < Math.abs(ans - target)) {
                ans = node.val;
            }

            if (target > node.val) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        return ans;
    }
}
