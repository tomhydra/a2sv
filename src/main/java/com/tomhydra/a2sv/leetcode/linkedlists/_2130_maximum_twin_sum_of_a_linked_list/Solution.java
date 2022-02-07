package com.tomhydra.a2sv.leetcode.linkedlists._2130_maximum_twin_sum_of_a_linked_list;

import com.tomhydra.a2sv.leetcode.common.ListNode;

class Solution {
    private int maxSum = 0;
    public int pairSum(ListNode head) {
        pairSum(head, head);
        return maxSum;
    }

    private ListNode pairSum(ListNode head, ListNode firstNode) {
        if (head == null) {
            return firstNode;
        }

        ListNode first = pairSum(head.next, firstNode);

        int sum = first.val + head.val;
        maxSum = Math.max(sum, maxSum);

        return first.next;

    }
}