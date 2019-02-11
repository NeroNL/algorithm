package 亚麻.TreeAndGraph;

import generalClass.TreeNode;

/**
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 *
 * The successor of a node p is the node with the smallest key greater than p.val.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [2,1,3], p = 1
 * Output: 2
 * Explanation: 1's in-order successor node is 2. Note that both p and the return value is of TreeNode type.
 * Example 2:
 *
 *
 * Input: root = [5,3,6,2,4,null,null,1], p = 6
 * Output: null
 * Explanation: There is no in-order successor of the current node, so the answer is null.
 *
 *
 * Note:
 *
 * If the given node has no in-order successor in the tree, return null.
 * It's guaranteed that the values of the tree are unique.
 */
public class InOrderTraversal {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        if (p == null) {
            return p;
        }

        if (p.right != null) {
            TreeNode node = p.right;
            while (node != null && node.left != null) {
                node = node.left;
            }
            return node;
        }

        TreeNode parent = findParent(root,p);
        while(parent != null && p == parent.right) {
            p = parent;
            parent = findParent(root,p);
        }
        return parent;


    }

    TreeNode findParent(TreeNode root, TreeNode child) {
        if(root == null) return null;
        if((root.left != null && root.left.val == child.val)
                || (root.right != null && root.right.val == child.val)) {
            return root;
        }
        else if(root.val > child.val) return findParent(root.left, child);
        else return findParent(root.right, child);
    }
}
