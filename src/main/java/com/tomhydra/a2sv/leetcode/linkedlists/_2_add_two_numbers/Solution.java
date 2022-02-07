package com.tomhydra.a2sv.leetcode.linkedlists._2_add_two_numbers;

import com.tomhydra.a2sv.leetcode.common.ListNode;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Edge cases
        if (l1 == null || l2 == null) {
            throw new IllegalArgumentException("Arguments can not be null");
        }
        ListNode result = new ListNode(0);
        ListNode resultRoot = result;
        ListNode currentL1 = l1;
        ListNode currentL2 = l2;
        int carry = 0;
        while (currentL1 != null || currentL2 != null || carry != 0) {
            int sum = carry;
            if (currentL1 != null) {
                sum += currentL1.val;
                currentL1 = currentL1.next;
            }
            if (currentL2 != null) {
                sum += currentL2.val;
                currentL2 = currentL2.next;
            }
            carry = sum / 10;
            result.next = new ListNode(sum % 10);
            result = result.next;
        }

        return resultRoot.next;


    }
}