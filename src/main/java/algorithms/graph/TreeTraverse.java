package algorithms.graph;
import common.TreeNode;

public class TreeTraverse {

    /**
     * 一、中序遍历
     * 步骤：
     *
     * 1. 如果当前节点的左孩子为空，则输出当前节点并将其右孩子作为当前节点。
     *
     * 2. 如果当前节点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点。
     *
     *    a) 如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。当前节点更新为当前节点的左孩子。
     *
     *    b) 如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空（恢复树的形状）。输出当前节点。当前节点更新为当前节点的右孩子。
     *
     * 3. 重复以上1、2直到当前节点为空。
     * @param root
     */
    public static void morrisTraversePrint(TreeNode root) {
        TreeNode cur = root, prev = null;
        StringBuilder sb = new StringBuilder();
        while(cur != null) {
            if (cur.left == null) {
                sb.append(cur.val).append(",");
                cur = cur.right;
            } else {
                prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    sb.append(cur.val).append(",");
                    cur = cur.right;
                }
            }
        }
        System.out.println(sb);
    }

    /**
     * 二、前序遍历
     * 前序遍历与中序遍历相似，代码上只有一行不同，不同就在于输出的顺序。
     *
     * 步骤：
     *
     * 1. 如果当前节点的左孩子为空，则输出当前节点并将其右孩子作为当前节点。
     *
     * 2. 如果当前节点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点。
     *
     *    a) 如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。输出当前节点（在这里输出，这是与中序遍历唯一一点不同）。当前节点更新为当前节点的左孩子。
     *
     *    b) 如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空。当前节点更新为当前节点的右孩子。
     *
     * 3. 重复以上1、2直到当前节点为空。
     * @param root
     */
    public static void morrisTraversePreOrderPrint(TreeNode root) {
        TreeNode cur = root, prev = null;
        StringBuilder sb = new StringBuilder();
        while(cur != null) {
            if (cur.left == null) {
                sb.append(cur.val).append(",");
                cur = cur.right;
            } else {
                prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    sb.append(cur.val).append(",");
                    cur = cur.left;
                } else {
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        System.out.println(sb);
    }

    private static void revert(TreeNode from, TreeNode to) {
        if (from == to) return ;
        TreeNode x = from, y = from.right, z;
        while(true) {
            z = y.right;
            y.right = x;
            x = y;
            y = z;
            if (x == to) break;
        }
    }

    private static void reverse(TreeNode from, TreeNode to, StringBuilder sb) {
        revert(from, to);
        TreeNode p = to;
        while (true) {
            sb.append(p.val).append(",");
            if (p == from) break;
            p = p.right;
        }
        revert(to, from);
    }

    /**
     * 三、后序遍历
     *
     * 后续遍历稍显复杂，需要建立一个临时节点dump，令其左孩子是root。并且还需要一个子过程，就是倒序输出某两个节点之间路径上的各个节点。
     *
     * 步骤：
     *
     * 当前节点设置为临时节点dump。
     *
     * 1. 如果当前节点的左孩子为空，则将其右孩子作为当前节点。
     *
     * 2. 如果当前节点的左孩子不为空，在当前节点的左子树中找到当前节点在中序遍历下的前驱节点。
     *
     *    a) 如果前驱节点的右孩子为空，将它的右孩子设置为当前节点。当前节点更新为当前节点的左孩子。
     *
     *    b) 如果前驱节点的右孩子为当前节点，将它的右孩子重新设为空。倒序输出从当前节点的左孩子到该前驱节点这条路径上的所有节点。当前节点更新为当前节点的右孩子。
     *
     * 3. 重复以上1、2直到当前节点为空。
     * @param root
     */
    public static void morrisTraversePostOrderPrint(TreeNode root) {
        TreeNode dump = new TreeNode(-1);
        dump.left = root;
        TreeNode cur = dump, prev = null;
        StringBuilder sb = new StringBuilder();
        while(cur != null) {
            if (cur.left == null) {
                cur = cur.right;
            } else {
                prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    reverse(cur.left, prev, sb);
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        System.out.println(sb);
    }

    public static void middleRecursionPrint(TreeNode root) {
       if (root == null) return ;

        middleRecursionPrint(root.left);
        System.out.println(root.val);
        middleRecursionPrint(root.right);
    }


    public static void main(String[] args) {
        TreeNode root = TreeNode.deserialize("6,2,1,null,null,4,3,null,null,5,null,null,7,null,9,8,null,null,null,");
        TreeNode node = TreeNode.deserialize("6,2,1,null,null,4,3,null,null,5,null,null,7,null,9,8,null,null,null,");
        morrisTraversePostOrderPrint(root);
        middleRecursionPrint(node);
    }
}
