package com.tomhydra.a2sv.leetcode.trie._208_implement_trie_prefix_tree;

import java.util.*;

public class Trie {
    boolean endWord = false;
    Map<Character, Trie> children;

    public Trie() {
        children = new HashMap<>();
    }
    
    public void insert(String word) {
        Trie current = this;
        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                current.children.put(c, new Trie());
            }
            current = current.children.get(c);
        }
        current.endWord = true;
    }
    
    public boolean search(String word) {
        Trie current = this;
        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return false;
            }
            current = current.children.get(c);
        }
        return current.endWord;
    }
    
    public boolean startsWith(String prefix) {
        Trie current = this;
        for (char c : prefix.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return false;
            }
            current = current.children.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */