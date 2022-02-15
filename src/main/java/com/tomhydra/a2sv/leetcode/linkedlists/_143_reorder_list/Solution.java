package com.tomhydra.a2sv.leetcode.linkedlists._143_reorder_list;

import com.tomhydra.a2sv.leetcode.common.ListNode;

class Solution {
    public void reorderList(ListNode head) {
        ListNode current = head;
        int size = 0;
        while (current != null) {
            size++;
            current = current.next;
        }
        int mid = (size - 1) / 2;
        reorderListHelper(head, 0, mid, size);
    }

    public ListNode reorderListHelper(ListNode node, int currentIndex, int midIndex, int size) {
        if (node == null) return null;
        if (currentIndex == midIndex) {
            ListNode result = node.next;
            if (size % 2 == 0) {
                result = result.next;
                node.next.next = null;
                return result;
            }  else {
                node.next = null;
            }
            return result;
        }
        ListNode next = node.next;
        ListNode result = reorderListHelper(node.next, currentIndex + 1, midIndex, size);
        node.next = result;
        ListNode temp = result.next;
        result.next = next;
        return temp;

    }
}