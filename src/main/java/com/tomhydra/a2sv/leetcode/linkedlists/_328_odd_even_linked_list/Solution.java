package com.tomhydra.a2sv.leetcode.linkedlists._328_odd_even_linked_list;

import com.tomhydra.a2sv.leetcode.common.ListNode;

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode even = head.next;

        ListNode evenDummy = new ListNode(0);
        evenDummy.next = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenDummy.next;

        return head;

    }
}