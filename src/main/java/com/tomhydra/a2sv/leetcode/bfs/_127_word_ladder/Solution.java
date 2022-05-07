package com.tomhydra.a2sv.leetcode.bfs._127_word_ladder;

import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordListSet = new HashSet<>(wordList);
        
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        wordListSet.remove(beginWord);
        
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String neighbor : getNeighbors(word, wordListSet)) {
                    if (neighbor.equals(endWord)) return count + 1;
                    queue.add(neighbor);
                    wordListSet.remove(neighbor);
                }

            }
            
            count++;
        }
        return 0;
    }
    
    private List<String> getNeighbors(String word, Set<String> wordList) {
        char[] chars = word.toCharArray();
        List<String> neighbors = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            for (int j = 0; j < 26; j++) {
                chars[i] = (char)('a' + j);
                String neighbor = String.valueOf(chars);
                if ( wordList.contains(neighbor)) {
                    neighbors.add(neighbor);
                }
            }
            chars[i] = temp;
        }
        return neighbors;
    }
}