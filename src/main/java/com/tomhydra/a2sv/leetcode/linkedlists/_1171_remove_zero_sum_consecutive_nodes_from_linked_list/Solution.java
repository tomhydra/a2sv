package com.tomhydra.a2sv.leetcode.linkedlists._1171_remove_zero_sum_consecutive_nodes_from_linked_list;

import com.tomhydra.a2sv.leetcode.common.ListNode;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        int sum = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        Map<Integer, ListNode> prefixSum = new HashMap<>();
        ListNode current = head;
        prefixSum.put(0, dummy);
        while (current != null) {
            sum += current.val;
            prefixSum.put(sum, current);
            current = current.next;
        }

        current = dummy;
        sum = 0;
        while (current != null) {
            sum += current.val;
            current.next = prefixSum.get(sum).next;
            current = current.next;
        }

        return dummy.next;

    }
}