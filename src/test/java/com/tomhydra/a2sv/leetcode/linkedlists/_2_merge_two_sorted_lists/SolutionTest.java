package com.tomhydra.a2sv.leetcode.linkedlists._2_merge_two_sorted_lists;

import com.tomhydra.a2sv.leetcode.common.ListNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution;

    @BeforeEach
    void setup() {
        solution = new Solution();
    }

    @Test
    void testMergeTwoLists() {
        ListNode list1 = new ListNode(new int[]{1,2,4});
        ListNode list2 = new ListNode(new int[]{1,3,4});

        ListNode result = solution.mergeTwoLists(list1, list2);

        Assertions.assertThat(result).isEqualTo(new ListNode(new int[]{1,1,2,3,4,4}));
    }
}