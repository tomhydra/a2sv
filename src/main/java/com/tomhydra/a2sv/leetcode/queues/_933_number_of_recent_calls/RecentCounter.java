package com.tomhydra.a2sv.leetcode.queues._933_number_of_recent_calls;

import java.util.LinkedList;

class RecentCounter {
    private LinkedList<Integer> queue;
    private final int INTERVAL = 3000;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.addLast(t);
        int floorValue = t - INTERVAL;
        while (!queue.isEmpty() && queue.getFirst() < floorValue) {
            queue.removeFirst();
        }
        return queue.size();
    }
}
