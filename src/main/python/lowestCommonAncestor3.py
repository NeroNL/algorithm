"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        this.val = val
        this.left, this.right = None, None
"""


class Solution:
    """
    @param: root: The root of the binary tree.
    @param: A: A TreeNode
    @param: B: A TreeNode
    @return: Return the LCA of the two nodes.
    """
    def lowestCommonAncestor3(self, root, A, B):
        # write your code here
        self.res = None
        self.helper(root, A, B)
        return self.res

    def helper(self, node, a, b):
        res = [0,0]
        if not node:
            return res
        l_res = self.helper(node.left, a, b)
        r_res = self.helper(node.right, a, b)
        if (l_res[0] or r_res[0]) or node == a:
            res[0] = 1
        if (l_res[1] or r_res[1]) or node == b:
            res[1] = 1
        if res[0] and res[1] and not self.res:
            self.res = node
        return res