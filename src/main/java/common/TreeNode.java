package common;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int x) {
        val = x;
    }

    private static String rserialize(TreeNode root, String str) {
        // Recursive serialization.
        if (root == null) {
            str += "null,";
        } else {
            str += root.val + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        return rserialize(root, "");
    }

    private static TreeNode rdeserialize(List<String> l) {
        // Recursive deserialization.
        if (l.get(0).equals("null")) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(l.get(0)));
        l.remove(0);
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);

        return root;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<>(Arrays.asList(data_array));
        return rdeserialize(data_list);
    }
}
