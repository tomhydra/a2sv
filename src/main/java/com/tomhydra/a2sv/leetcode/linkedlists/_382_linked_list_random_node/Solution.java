package com.tomhydra.a2sv.leetcode.linkedlists._382_linked_list_random_node;

import com.tomhydra.a2sv.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    int size;
    List<ListNode> nodes;

    public Solution(ListNode head) {
        nodes = new ArrayList<>();
        ListNode current = head;
        size = 0;
        while (current != null) {
            nodes.add(current);
            current = current.next;
        }
    }

    public int getRandom() {
        int idx = (int)(Math.random() * this.nodes.size());
        return this.nodes.get(idx).val;
    }
}
