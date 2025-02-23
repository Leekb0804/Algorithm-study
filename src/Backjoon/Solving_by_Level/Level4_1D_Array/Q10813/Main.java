package Backjoon.Solving_by_Level.Level4_1D_Array.Q10813;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        for(int i = 0; i < M; i++){
            int index1 = sc.nextInt() - 1;
            int index2 = sc.nextInt() - 1;
            int tmp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = tmp;
        }
        for(int i = 0; i < N; i++){
            sb.append(arr[i] + " ");
        }
        System.out.println(sb);
        sc.close();
    }
}
