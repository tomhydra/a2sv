package com.tomhydra.a2sv.leetcode.queues._641_design_circular_deque;

class MyCircularDeque {
    int maxSize = 0;
    int size = 0;
    private QueueItem head;
    private QueueItem tail;

    public MyCircularDeque(int k) {
        this.maxSize = k;

    }

    public boolean insertFront(int value) {
        if (size >= maxSize) return false;
        if (head == null) {
            head = new QueueItem(value);
            tail = head;
        } else {
            QueueItem temp = head;
            head = new QueueItem(value);
            temp.next = head;
            head.prev = temp;
        }
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (size >= maxSize) return false;
        if (tail == null) {
            tail = new QueueItem(value);
            head = tail;
        } else {
            QueueItem temp = tail;
            tail = new QueueItem(value);
            tail.next = temp;
            temp.prev = tail;
        }
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (head == null) return false;
        // single item
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.prev;
            head.next = null;
        }

        size--;
        return true;
    }

    public boolean deleteLast() {
        if (tail == null) return false;
        // single item
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.next;
            tail.prev = null;
        }
        size--;
        return true;
    }

    public int getFront() {
        if (head == null) return -1;
        return head.val;
    }

    public int getRear() {
        if (tail == null) return -1;
        return tail.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }
}

class QueueItem {
    public QueueItem next;
    public QueueItem prev;
    public int val;

    public QueueItem(int val) {
        this.val = val;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
