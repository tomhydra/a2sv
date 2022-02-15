package com.tomhydra.a2sv.leetcode.linkedlists._725_split_linked_list_in_parts;

import com.tomhydra.a2sv.leetcode.common.ListNode;

class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        if (head == null) return result;

        ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }

        int each = count / k;
        int addition = count % k;

        ListNode start = head;
        ListNode prev = null;
        for (int i = 0; i < k; i++) {
            prev = null;
            current = start;

            for (int j = 0; j < each; j++) {
                prev = current;
                current = current.next;
            }
            if (addition > 0) {
                prev = current;
                current = current.next;
                addition--;
            }
            if (prev == null) break;
            ListNode temp = current;
            prev.next = null;
            result[i] = start;
            start = temp;
        }

        return result;

    }
}