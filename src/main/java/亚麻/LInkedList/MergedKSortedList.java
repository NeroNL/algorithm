package 亚麻.LInkedList;

import generalClass.ListNode;

public class MergedKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(-1), tmp = res;

        while(true) {

            int min = Integer.MAX_VALUE, id = -1;

            for (int i = 0; i < lists.length; ++i) {
                if (lists[i] != null && lists[i].val < min) {
                    min = lists[i].val;
                    id = i;
                }
            }

            if (id == -1) {
                break;
            }

            tmp.next = new ListNode(lists[id].val);
            tmp = tmp.next;
            lists[id] = lists[id].next;
        }

        return res.next;
    }
}
