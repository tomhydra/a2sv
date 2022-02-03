package com.tomhydra.a2sv.leetcode.linkedlists._83_remove_duplicates_from_sorted_list;

import com.tomhydra.a2sv.leetcode.common.ListNode;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // validate input
        if (head == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode current = head;
        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }

        }
        return dummy.next;
    }
}