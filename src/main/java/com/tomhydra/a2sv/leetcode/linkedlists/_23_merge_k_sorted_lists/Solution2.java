package com.tomhydra.a2sv.leetcode.linkedlists._23_merge_k_sorted_lists;

import com.tomhydra.a2sv.leetcode.common.ListNode;

public class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        ListNode resultNode = new ListNode(0);
        ListNode dummyHead = resultNode;

        while (true) {
            int minValue = Integer.MAX_VALUE;
            for (ListNode list : lists) {
                if (list != null)
                    minValue = Math.min(list.val, minValue);
            }
            int done = 0;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    done++;
                }
                else if (lists[i].val == minValue) {
                    resultNode.next = new ListNode(lists[i].val);
                    resultNode = resultNode.next;
                    lists[i] = lists[i].next;
                }
            }
            if (done == lists.length) {
                break;
            }


        }
        return dummyHead.next;

    }
}
