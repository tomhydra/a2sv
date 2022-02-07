package com.tomhydra.a2sv.leetcode.linkedlists._142_linked_list_cycle_ii;

import com.tomhydra.a2sv.leetcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        Set<ListNode> visited = new HashSet<>();
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            if (visited.contains(fast)) {
                return fast;
            } else if (visited.contains(fast.next)) {
                return fast.next;
            }
            visited.add(slow);
            slow = slow.next;
            fast = fast.next.next;

        }
        return null;
    }
}