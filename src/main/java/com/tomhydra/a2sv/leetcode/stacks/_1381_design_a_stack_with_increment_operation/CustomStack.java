package com.tomhydra.a2sv.leetcode.stacks._1381_design_a_stack_with_increment_operation;

import java.util.ArrayList;
import java.util.List;

class CustomStack {
    private final List<Integer> stack;
    private final int maxSize;
    public CustomStack(int maxSize) {
        stack = new ArrayList<>(maxSize);
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if (stack.size() >= maxSize) return;
        stack.add(x);
    }

    public int pop() {
        if (stack.isEmpty()) return -1;
        int popped = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return popped;
    }

    public void increment(int k, int val) {
        int size = Math.min(stack.size(), k);
        for (int i = 0; i < size; i++) {
            stack.set(i, stack.get(i) + val);
        }
    }
}

