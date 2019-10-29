package Amazon.TreeAndGraph;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
 *
 * Example 1:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 * Example 2:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return false.
 */
public class SubTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(s);

        TreeNode tmp = null;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) continue;

            if (node.val == t.val && helper(node, t)) {
                return true;
            }

            queue.offer(node.left);
            queue.offer(node.right);
        }

        return false;
    }

    public boolean helper(TreeNode s, TreeNode t) {
        if (t == null && s == null) {
            return true;
        } else if (t != null && s == null) {
            return false;
        } else if (t == null) {
            return false;
        }

        return s.val == t.val && helper(s.left, t.left) && helper(s.right, t.right);
    }
}
