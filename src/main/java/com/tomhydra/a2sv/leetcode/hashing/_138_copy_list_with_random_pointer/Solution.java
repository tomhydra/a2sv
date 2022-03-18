package com.tomhydra.a2sv.leetcode.hashing._138_copy_list_with_random_pointer;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Solution {
    private Map<Node, Node> nodes = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        if (nodes.containsKey(head)) return nodes.get(head);
        Node newNode = new Node(head.val);
        nodes.put(head, newNode);
        newNode.next = copyRandomList(head.next);
        newNode.random = copyRandomList(head.random);
        return newNode;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}