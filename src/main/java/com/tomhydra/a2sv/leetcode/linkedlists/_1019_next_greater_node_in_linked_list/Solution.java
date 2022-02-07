package com.tomhydra.a2sv.leetcode.linkedlists._1019_next_greater_node_in_linked_list;

import com.tomhydra.a2sv.leetcode.common.ListNode;

import java.util.Stack;

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        if (head == null) return new int[0];
        int[] result = new int[getSize(head)];
        Stack<ListNodeItem> stack = new Stack<>();
        int counter = 0;
        ListNode current = head;
        while (current != null) {
            while (!stack.isEmpty() && stack.peek().node.val < current.val) {
                ListNodeItem top = stack.pop();
                result[top.index] = current.val;
            }
            stack.push(new ListNodeItem(counter, current));
            counter++;
            current = current.next;
        }
        return result;
    }

    private int getSize(ListNode head) {
        if (head == null) return 0;
        ListNode current = head;
        int size = 0;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }
}

class ListNodeItem {
    public int index;
    public ListNode node;

    public ListNodeItem(int index, ListNode node) {
        this.index = index;
        this.node = node;
    }
}