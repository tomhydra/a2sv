package com.tomhydra.a2sv.leetcode.linkedlists._206_reverse_linked_list;

import com.tomhydra.a2sv.leetcode.common.ListNode;

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode current = head;
        ListNode prev = null;
        while (current.next != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        current.next = prev;
        return current;
    }
}