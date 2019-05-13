package 亚麻.TreeAndGraph;

import common.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
 *
 * Example 1:
 *
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * Output: True
 *
 *
 * Example 2:
 *
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * Output: False
 */
public class TwoSumIv {

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) continue;

            int diff = k - node.val;

            if(set.contains(diff)) {
                return true;
            }

            set.add(node.val);

            queue.offer(node.left);
            queue.offer(node.right);
        }

        return false;
    }
}
