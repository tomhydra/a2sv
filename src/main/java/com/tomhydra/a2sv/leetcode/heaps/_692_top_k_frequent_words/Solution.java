package com.tomhydra.a2sv.leetcode.heaps._692_top_k_frequent_words;

import java.util.*;

public class Solution {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<String> minHeap = new PriorityQueue<>(k, new LexigographicalComparator(freq));
        
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            minHeap.add(entry.getKey());
        }
        int size = minHeap.size();
        List<String> result = new ArrayList<>();
        
        while (!minHeap.isEmpty() && k > 0) {
            result.add(minHeap.poll());
            k--;
        }
        
        return result;
    }
    
    
}

class LexigographicalComparator implements Comparator<String> {
    Map<String, Integer> freqs;
    public LexigographicalComparator(Map<String, Integer> freqs) {
        this.freqs = freqs;
    }
    
    @Override
    public int compare(String first, String second) {
        int firstFreq = freqs.get(first);
        int secondFreq = freqs.get(second);
        
        if (firstFreq == secondFreq) {
            return first.compareTo(second);
        }
        return secondFreq - firstFreq;
    }
}