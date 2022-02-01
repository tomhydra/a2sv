package com.tomhydra.a2sv.leetcode.arrays._88_merge_sorted_array;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


class SolutionTest {

    @Test
    public void testMerge() {
        for (TestCase t : getTestCases()) {
            Solution solution = new Solution();
            solution.merge(t.nums1, t.n, t.nums2, t.m);

            Assertions.assertThat(t.nums1).containsExactly(t.expected);
        }
    }

    private List<TestCase> getTestCases() {
        return Arrays.asList(
                new TestCase(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3, new int[]{1,2,2,3,5,6}),
                new TestCase(new int[]{1}, 1, new int[]{}, 0, new int[]{1}),
                new TestCase(new int[]{0}, 0, new int[]{1}, 1, new int[]{1})
        );
    }


}

final class TestCase {
    public int[] nums1;
    public int n;
    public int[] nums2;
    public int m;
    public int[] expected;

    public TestCase(int[] nums1, int n, int[] nums2, int m, int[] expected) {
        this.nums1 = nums1;
        this.n = n;
        this.nums2 = nums2;
        this.m = m;
        this.expected = expected;
    }
}