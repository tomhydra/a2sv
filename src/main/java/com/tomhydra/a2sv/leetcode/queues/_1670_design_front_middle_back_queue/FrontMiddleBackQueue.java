package com.tomhydra.a2sv.leetcode.queues._1670_design_front_middle_back_queue;

class FrontMiddleBackQueue {
    int size = 0;
    QueueItem head;
    QueueItem tail;
    QueueItem middle;


    public FrontMiddleBackQueue() {

    }

    public void pushBack(int val) {
        QueueItem newItem = new QueueItem(val);
        if (head == null) {
            initializeQueue(newItem);
        } else {
            QueueItem temp = head;
            head = newItem;
            temp.next = head;
            head.prev = temp;
        }
        // move middle pointer to the right
        if (size % 2 == 0 && size > 0) {
            middle = middle.next;
        }
        size++;

    }

    public void pushMiddle(int val) {
        QueueItem newItem = new QueueItem(val);
        if (middle == null) {
            initializeQueue(newItem);
        } else if (size == 1) {
            pushFront(val);
            return;
        } else {
            QueueItem temp = middle;
            middle = newItem;
            if (size % 2 == 1) {
                middle.prev = temp.prev;
                middle.next = temp;
                middle.prev.next = middle;
                temp.prev = middle;
            } else {
                middle.prev = temp;
                middle.next = temp.next;
                middle.next.prev = middle;
                temp.next = middle;
            }
        }
        size++;

    }

    public void pushFront(int val) {
        QueueItem newItem = new QueueItem(val);
        if (tail == null) {
            initializeQueue(newItem);
        } else {
            QueueItem temp = tail;
            tail = newItem;
            tail.next = temp;
            temp.prev = tail;
        }

        // move middle pointer to the right
        if (size % 2 == 1 && size > 0) {
            middle = middle.prev;
        }
        size++;
    }

    public int popBack() {
        if (head == null) return -1;
        int val = head.val;
        if (size == 1) {
            resetQueue();
        } else {
            head = head.prev;
            head.next = null;
            if (size % 2 == 1) {
                middle = middle.prev;
            }
        }
        size--;
        return val;
    }

    public int popMiddle() {
        if (middle == null) return -1;
        int val = middle.val;
        if (size == 1) {
            resetQueue();
        } else if (size == 2) {
            return popFront();
        } else {
            if (size % 2 == 1) {
                middle = middle.prev;
                middle.next = middle.next.next;
                middle.next.prev = middle;
            } else {
                middle = middle.next;
                middle.prev = middle.prev.prev;
                middle.prev.next = middle;
            }
        }
        size--;
        return val;
    }

    public int popFront() {
        if (tail == null) return -1;
        int val = tail.val;
        if (size == 1) {
            resetQueue();
        } else {
            tail = tail.next;
            tail.prev = null;
            if (size % 2 == 0) {
                middle = middle.next;
            }
        }
        size--;
        return val;

    }

    private void initializeQueue(QueueItem newItem) {
        head = newItem;
        tail = newItem;
        middle = newItem;
    }

    private void resetQueue() {
        head = null;
        tail = null;
        middle = null;
    }

}

class QueueItem {
    public int val;
    public QueueItem next;
    public QueueItem prev;

    public QueueItem(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (this.prev != null) {
            result.append(prev.val).append(" <- ");
        }
        result.append(val);
        if (next != null) {
            result.append(" -> ").append(next.val);
        }
        return result.toString();
    }
}