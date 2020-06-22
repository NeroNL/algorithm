# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from collections import deque
class Solution:
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        queue,layer, res = deque([root]),0, []
        while queue:
            layer += 1
            cur = []
            for _ in range(len(queue)):
                node = queue.popleft()
                cur.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            if layer % 2 == 0:
                cur.reverse()
            res.append(cur)
        return res