package Backjoon.Solving_by_Level.Level4_1D_Array.Q3052;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < 10; i++) {
            int n = sc.nextInt() % 42;
            set.add(n);
        }
        System.out.println(set.size());
        sc.close();
    }
}
