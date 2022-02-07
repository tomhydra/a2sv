package com.tomhydra.a2sv.leetcode.linkedlists._876_middle_of_the_linked_list;

import com.tomhydra.a2sv.leetcode.common.ListNode;

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slower = head, faster = head;
        while (faster != null && faster.next != null) {
            slower = slower.next;
            faster = faster.next.next;
        }
        return slower;
    }
}