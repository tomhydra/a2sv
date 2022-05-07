package com.tomhydra.a2sv.leetcode.heaps._23_merge_k_sorted_lists;

import com.tomhydra.a2sv.leetcode.common.ListNode;

import java.util.*;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        LinkedList<ListNode> queue = new LinkedList<>();
        
        for (ListNode node : lists) {
            queue.offer(node);
        }
        ListNode result = new ListNode(0);
        ListNode dummy = new ListNode(0);
        dummy.next = result;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode min = null;
            for (int i = 0; i < size; i++) {
                ListNode node = queue.poll();
                if (node == null) continue;
                if (min == null) {
                    min = node;
                } else {
                    if (node.val < min.val) {
                        queue.offer(min);
                        min = node;
                    } else {
                        queue.offer(node);
                    }
                }
            }
            
            result.next = min;
            result = result.next;
            if (min == null) break;
            min = min.next;
            if (min != null) {
                queue.offer(min);    
            }
            

        } 
        return dummy.next.next;
    }
}