package Backjoon.Solving_by_Level.Level23_Greedy.Q11047;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] coins = new int[N];

    for(int i = 0; i < N; i++) {
      coins[i] = Integer.parseInt(br.readLine());
    }

    int index = N - 1;
    int cnt = 0;
    while (K > 0) {
      cnt += K / coins[index];
      K %= coins[index];
      index--;
    }

    System.out.println(cnt);
    br.close();
  }
}