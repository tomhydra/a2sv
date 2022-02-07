package com.tomhydra.a2sv.hackerrank.cycle_detection;

import com.tomhydra.a2sv.hackerrank.common.SinglyLinkedListNode;

public class Solution {
    static boolean hasCycle(SinglyLinkedListNode head) {
        SinglyLinkedListNode slower = head;
        SinglyLinkedListNode faster = head;
        while (faster != null && faster.next != null) {
            slower = slower.next;
            faster = faster.next.next;
            if (slower == faster) {
                return true;
            }
        }
        return false;

    }
}
