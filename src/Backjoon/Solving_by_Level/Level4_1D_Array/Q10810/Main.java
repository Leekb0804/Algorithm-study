package Backjoon.Solving_by_Level.Level4_1D_Array.Q10810;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int loop = 0; loop < M; loop++) {
            int i = sc.nextInt() - 1;
            int j = sc.nextInt() - 1;
            int num = sc.nextInt();
            for (int k = i; k <= j; k++) {
                arr[k] = num;
            }
        }
        for(int i = 0; i < N; i++) {
            sb.append(arr[i] + " ");
        }
        System.out.println(sb);
        sc.close();
    }
}
