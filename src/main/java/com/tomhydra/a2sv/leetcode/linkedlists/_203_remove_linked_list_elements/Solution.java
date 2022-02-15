package com.tomhydra.a2sv.leetcode.linkedlists._203_remove_linked_list_elements;

import com.tomhydra.a2sv.leetcode.common.ListNode;

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode current = head;

        current = new ListNode(0);
        current.next = head;
        ListNode dummy = current;

        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return dummy.next;
    }
}