package com.tomhydra.a2sv.leetcode.trie._211_design_add_and_search_words_data_structure;

import java.util.*;

public class WordDictionary {
    Trie root;

    public WordDictionary() {
        root = new Trie();
    }
    
    public void addWord(String word) {
        root.insert(word);
    }
    
    public boolean search(String word) {
        return search(root, word);
    }
    
    private boolean search(Trie node, String word) {
        char[] chars = word.toCharArray();
        Trie current = node;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '.') {
                return searchInChildren(current, word.substring(i+1, word.length()));
            } 
            else if (!current.children.containsKey(chars[i])) {
                return false;
            }
            current = current.children.get(chars[i]);
        }
        return current.isWord;
    }
    
    private boolean searchInChildren(Trie node, String word) {
        char[] chars = word.toCharArray();
        boolean found = false;
        for (Map.Entry<Character, Trie> child : node.children.entrySet()) {
            found = search(child.getValue(), word);
            if (found) return true;
        }
        return false;
    }
}

class Trie {
    public boolean isWord;
    public Map<Character, Trie> children;
    
    public Trie() {
        children = new HashMap<>();    
    }
    
    public void insert(String word) {
        char[] chars = word.toCharArray();
        Trie current = this;
        for (int i = 0; i < chars.length; i++) {
            if (!current.children.containsKey(chars[i])) {
                current.children.put(chars[i], new Trie());
            }
            current = current.children.get(chars[i]);
        }
        current.isWord = true;
    }
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */