package com.tomhydra.a2sv.hackerrank.fraudulent_activity_notifications;

import java.util.*;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'activityNotifications' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY expenditure
     *  2. INTEGER d
     */

    public static int activityNotifications(List<Integer> expenditure, int d) {
        // Write your code here
        int[] count = new int[201];
        int notifications = 0;
        for (int i = 0; i < expenditure.size(); i++) {
            if (i >= d) {
                double median = getMedian(count, d);
                notifications += expenditure.get(i) >= (2 * median) ? 1 : 0;
                count[expenditure.get(i - d)]--;
            }
            count[expenditure.get(i)]++;
        }
        System.out.println("notifications " + notifications);
        return notifications;

    }

    private static double getMedian(int[] count, int d) {
        int found = 0;
        int idx = 0;
        int middle = (d+1) / 2;
        while (idx < count.length) {
            found += count[idx];
            if (found >= middle) {
                found -= count[idx];
                break;
            }
            idx++;
        }
        double result = idx;
        if (d % 2 == 0) {
            if (count[idx] > (middle - found)) return idx;
            int prev = idx;
            idx++;
            while (idx < count.length) {
                if (count[idx] >= 1) {
                    result = (prev + idx) / 2.0;
                    break;
                }
                idx++;
            }
        }
        return result;
    }

}

