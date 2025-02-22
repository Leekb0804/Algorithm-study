package Backjoon.Solving_by_Level.Level4_1D_Array.Q10807;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int find = sc.nextInt();
        int result = 0;
        for(int i = 0 ; i < N ; i++){
            if(arr[i] == find){
                result++;
            }
        }
        System.out.println(result);
        sc.close();
    }
}
