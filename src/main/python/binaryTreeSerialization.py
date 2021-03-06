"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""

from collections import deque
class Solution:
    """
    @param root: An object of TreeNode, denote the root of the binary tree.
    This method will be invoked first, you should design your own algorithm
    to serialize a binary tree which denote by a root node to a string which
    can be easily deserialized by your own "deserialize" method later.
    """
    def serialize(self, root):
        # write your code here
        if not root:
            return ""
        queue = deque([root])
        res = []
        while queue:
            for _ in range(len(queue)):
                node = queue.popleft()
                res.append(str(node.val) if node else '#')
                if node:
                    queue.append(node.left)
                    queue.append(node.right)
        print(res)
        return ','.join(res)
    """
    @param data: A string serialized by your serialize method.
    This method will be invoked second, the argument data is what exactly
    you serialized at method "serialize", that means the data is not given by
    system, it's given by your own serialize method. So the format of data is
    designed by yourself, and deserialize it here as you serialize it in 
    "serialize" method.
    """
    def deserialize(self, data):
        # write your code here
        if not data:
            return None
        data = data.split(',')
        slow, fast, res = 0, 1, TreeNode(int(data[0]))
        nodes = [res]
        while fast < len(data):
            node = nodes[slow]
            node.left = TreeNode(int(data[fast])) if data[fast] != '#' else None
            node.right = TreeNode(int(data[fast+1])) if data[fast+1] != '#' else None
            if node.left:
                nodes.append(node.left)
            if node.right:
                nodes.append(node.right)
            slow += 1
            fast += 2
        return res