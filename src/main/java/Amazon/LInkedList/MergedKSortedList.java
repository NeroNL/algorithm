package Amazon.LInkedList;

import common.ListNode;


/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class MergedKSortedList {
    private ListNode sortMerge(ListNode n1, ListNode n2) {
        if (n1 == null) {
            return n2;
        } else if (n2 == null) {
            return n1;
        } else if (n1 == null && n2 == null) {
            return null;
        }

        ListNode node;
        if (n1.val > n2.val) {
            node = new ListNode(n2.val);
            node.next = sortMerge(n1, n2.next);
        } else {
            node = new ListNode(n1.val);
            node.next = sortMerge(n1.next, n2);
        }
        return node;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        int last = lists.length-1;
        while (last != 0) {
            int i = 0, j = last;

            // (i, j) forms a pair
            while (i < j)
            {
                // merge List i with List j and store
                // merged list in List i
                lists[i] = sortMerge(lists[i], lists[j]);

                // consider next pair
                i++; j--;

                // If all pairs are merged, update last
                if (i >= j)
                    last = j;
            }
        }

        return lists[0];
    }
}
