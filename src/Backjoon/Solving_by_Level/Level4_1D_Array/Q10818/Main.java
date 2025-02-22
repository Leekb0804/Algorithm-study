package Backjoon.Solving_by_Level.Level4_1D_Array.Q10818;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int min;
        int max;
        int num = sc.nextInt();
        min = num;
        max = num;
        for(int i = 1; i < N; i++) {
            num = sc.nextInt();
            if (min > num) {
                min = num;
            }
            if (max < num) {
                max = num;
            }
        }
        sb.append(min).append(" ").append(max).append("\n");
        System.out.println(sb);
        sc.close();
    }
}
