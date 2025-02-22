package Backjoon.Solving_by_Level.Level4_1D_Array.Q2562;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = n;
        int max_index = 1;
        for (int i = 2; i < 10; i++) {
            n = sc.nextInt();
            if (n > max) {
                max = n;
                max_index = i;
            }
        }
        System.out.println(max + "\n" + max_index);
        sc.close();
    }
}
