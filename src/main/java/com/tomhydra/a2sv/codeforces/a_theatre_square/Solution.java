package com.tomhydra.a2sv.codeforces.a_theatre_square;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int a = scanner.nextInt();

        long result = minFlagStones(n, m, a);
        System.out.println(result);
    }

    private static long minFlagStones(int n, int m, int a) {
        long width = n / a + (n % a > 0 ? 1 : 0);
        long length = m / a + (m % a > 0 ? 1 : 0);
        return width * length;
    }
}
