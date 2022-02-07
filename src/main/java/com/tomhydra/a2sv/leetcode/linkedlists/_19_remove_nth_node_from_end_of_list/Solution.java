package com.tomhydra.a2sv.leetcode.linkedlists._19_remove_nth_node_from_end_of_list;

import com.tomhydra.a2sv.leetcode.common.ListNode;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        removeNthFromEndHelper(dummy, n);
        return dummy.next;
    }

    private int removeNthFromEndHelper(ListNode head, int n) {
        if (head == null) return 0;

        int level = removeNthFromEndHelper(head.next, n);

        if (level == n) {
            head.next = head.next.next;
        }
        return 1 + level;
    }
}