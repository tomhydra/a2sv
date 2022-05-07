package com.tomhydra.a2sv.leetcode.heaps._703_kth_largest_element_in_a_stream;

import java.util.*;

public class KthLargest {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a,b));
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            minHeap.add(num);

        }
        
        while (minHeap.size() > k) {
            minHeap.poll();
        }
        
        
    }
    
    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */