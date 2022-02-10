package com.tomhydra.a2sv.codeforces.a_domino_piling;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();

        if (M == 1 && N == 1) {
            System.out.println(0);
        } else {
            System.out.println(M * N / 2);
        }
    }
}
