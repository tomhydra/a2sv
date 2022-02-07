package com.tomhydra.a2sv.leetcode.queues._1700_number_of_students_unable_to_eat_lunch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < students.length; i++) {
            queue.offer(students[i]);
            stack.push(sandwiches[sandwiches.length - 1 - i]);
        }
        boolean taken = false;
        do {
            taken = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if (current == stack.peek()) {
                    taken = true;
                    stack.pop();
                } else {
                    queue.offer(current);
                }
            }
        } while (!queue.isEmpty() && taken);

        return queue.size();

    }
}