package com.tomhydra.a2sv.leetcode.linkedlists._707_design_linked_list;


import java.util.ArrayList;
import java.util.List;

class MyLinkedList {
    LinkedListNode tail;
    LinkedListNode head;

    List<LinkedListNode> list;

    public MyLinkedList() {
        list = new ArrayList<>();
    }

    public int get(int index) {
        if (index < 0 || list.size() <= index) return -1;
        return list.get(index).val;
    }

    public void addAtTail(int val) {
        LinkedListNode temp = tail;
        tail = new LinkedListNode(val);
        if (temp == null) {
            head = tail;
        } else {
            temp.next = tail;
            tail.prev = temp;
        }
        list.add(tail);
    }

    public void addAtHead(int val) {
        LinkedListNode temp = head;
        head = new LinkedListNode(val);
        if (temp == null) {
            tail = head;
        } else {
            temp.prev = head;
            head.next = temp;
        }
        list.add(0, head);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > list.size()) return;
        LinkedListNode newNode = new LinkedListNode(val);
        if (list.size() == 0) {
            tail = newNode;
            head = newNode;
            list.add(newNode);
        }
        else if (list.size() == index) {
            LinkedListNode temp = tail;
            tail = newNode;
            temp.next = tail;
            tail.prev = temp;
            list.add(newNode);
        } else if (index == 0) {
            LinkedListNode temp = head;
            head = newNode;
            temp.prev = head;
            head.next = temp;
            list.add(0, newNode);
        } else {
            LinkedListNode next = list.get(index);
            LinkedListNode prev = list.get(index - 1);
            newNode.next = next;
            newNode.prev = prev;
            prev.next = newNode;
            next.prev = newNode;

            list.add(index, newNode);
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= list.size()) return;

        if (list.size() == 1) {
            head = null;
            tail = null;
        } else if (index == 0) {
            head = head.next;
        } else if (index == list.size() - 1) {
            tail = tail.prev;
        }

        list.remove(index);
    }
}

class LinkedListNode {
    public LinkedListNode next;
    public LinkedListNode prev;
    public int val;

    public LinkedListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (prev != null) {
            result.append(prev.val).append(" <- ");
        }
        result.append(val);
        if (next != null) {
            result.append(next.val).append(" -> ");
        }
        return result.toString();
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */