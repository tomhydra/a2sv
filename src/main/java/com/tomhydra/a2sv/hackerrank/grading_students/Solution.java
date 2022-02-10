package com.tomhydra.a2sv.hackerrank.grading_students;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> result = new ArrayList<>();
        for (int current : grades) {
            int lastDigit = current % 10;
            if (current >= 38 && ((lastDigit > 5 && 10 - lastDigit < 3)
                    || (lastDigit < 5 && 5 - lastDigit < 3))) {
                int addition = lastDigit > 5 ? 10 - lastDigit : 5 - lastDigit;
                result.add(current + addition);
            } else {
                result.add(current);
            }
        }
        return result;

    }
}
