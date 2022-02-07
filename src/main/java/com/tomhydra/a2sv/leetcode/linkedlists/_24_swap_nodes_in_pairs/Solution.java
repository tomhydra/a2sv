package com.tomhydra.a2sv.leetcode.linkedlists._24_swap_nodes_in_pairs;

import com.tomhydra.a2sv.leetcode.common.ListNode;

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = swapPairsHelper(head);

        return dummy.next;
    }

    private ListNode swapPairsHelper(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode temp = head.next;
        head.next = swapPairsHelper(head.next.next);
        temp.next = head;

        return temp;

    }
}