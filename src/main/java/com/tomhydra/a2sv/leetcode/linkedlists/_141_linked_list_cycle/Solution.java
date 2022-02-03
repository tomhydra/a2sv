package com.tomhydra.a2sv.leetcode.linkedlists._141_linked_list_cycle;

import com.tomhydra.a2sv.leetcode.common.ListNode;

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            if (slow == fast.next.next) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}