package Backjoon.Solving_by_Level.Level4_1D_Array.Q5597;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[31];
        for(int i = 0; i < 28; i++) {
            int n = sc.nextInt();
            arr[n] = 1;
        }
        for(int i = 1; i < 31; i++) {
            if (arr[i] == 0) {
                sb.append(i + " ");
            }
        }
        System.out.println(sb.toString());
        sc.close();
    }
}
