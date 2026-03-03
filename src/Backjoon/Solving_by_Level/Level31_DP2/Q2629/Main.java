package Backjoon.Solving_by_Level.Level31_DP2.Q2629;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] weight = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) {
      weight[i] = Integer.parseInt(st.nextToken());
      // System.out.println("weight[" + i + "] = " + weight[i]);
    }

    boolean[][] dp = new boolean[N][15001];
    dp[0][0] = true;
    dp[0][weight[0]] = true;

    for(int i = 0; i < N - 1; i++) {
      for(int j = 0; j <= 15000; j++) {
        if (dp[i][j] == true) {

          dp[i + 1][j] = true;
          dp[i + 1][j + weight[i + 1]] = true;
          dp[i + 1][Math.abs(j - weight[i + 1])] = true;

          // System.out.println("dp[" + (i + 1) + "][" + j + "] = " + dp[i + 1][j]);
          // System.out.println("dp[" + i + "][" + j + "] = " + dp[i + 1][j + weight[i + 1]]);
          // System.out.println("dp[" + i + "][" + (Math.abs(j - weight[i + 1]) + "] = " + dp[i + 1][Math.abs(j - weight[i + 1])]));
        }
      }
    }

    // System.out.println("clear1");

    int M = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < M; i++) {
      int tmp = Integer.parseInt(st.nextToken());
      if (tmp > 15000 || dp[N - 1][tmp] == false) {
        sb.append("N ");
      } else {
        sb.append("Y ");
      }
    }

    System.out.println(sb);
    br.close();
  }
}
