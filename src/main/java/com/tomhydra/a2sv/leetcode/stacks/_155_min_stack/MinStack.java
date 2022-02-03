package com.tomhydra.a2sv.leetcode.stacks._155_min_stack;

import java.util.ArrayList;
import java.util.List;

class MinStack {

    List<Integer> stack;
    List<Integer> minValues;

    public MinStack() {
        stack = new ArrayList<>();
        minValues = new ArrayList<>();
    }

    public void push(int val) {
        stack.add(val);
        if (stack.size() == 1) {
            minValues.add(val);
        } else {
            minValues.add(Math.min(minValues.get(minValues.size() - 1), val));
        }
    }

    public void pop() {
        validateStackSize(stack);
        stack.remove(stack.size() - 1);
        minValues.remove(minValues.size() - 1);
    }

    public int top() {
        validateStackSize(stack);
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        validateStackSize(stack);
        return minValues.get(minValues.size() - 1);
    }

    private void validateStackSize(List<Integer> stack) {
        if (stack.size() == 0) throw new IllegalStateException("Stack is empty");
    }
}
