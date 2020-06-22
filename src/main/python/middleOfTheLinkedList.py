"""
Definition of ListNode
class ListNode(object):
    def __init__(self, val, next=None):
        self.val = val
        self.next = next
"""

class Solution:
    """
    @param head: the head node
    @return: the middle node
    """
    def middleNode(self, head):
        # write your code here.
        if not head:
            return head
        slow, fast = head, head.next
        while fast:
            slow = slow.next
            fast = fast.next.next if fast.next else None
        return slow