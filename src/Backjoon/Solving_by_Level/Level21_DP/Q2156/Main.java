package Backjoon.Solving_by_Level.Level21_DP.Q2156;

import java.io.*;
import java.util.*;

public class Main {
  public static int[] alchol;
  public static int[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    alchol = new int[N];
    dp = new int[N];

    for(int i = 0; i < N; i++) {
      alchol[i] = Integer.parseInt(br.readLine());
    }

    dp[0] = alchol[0];
    for(int i = 1; i < N; i++) {
      dp[i] = dp[i - 1];

      if (i == 1) {
        dp[i] = dp[i - 1] + alchol[i];
      }

      if (i == 2) {
        dp[i] = Math.max(dp[i], alchol[1] + alchol[2]);
      }

      if (i - 2 >= 0) {
        dp[i] = Math.max(dp[i], dp[i - 2] + alchol[i]);
      }

      if (i - 3 >= 0) {
        dp[i] = Math.max(dp[i], dp[i - 3] + alchol[i - 1] + alchol[i]);
      }

      System.out.println("dp[" + i + "] = " + dp[i]);
    }

    System.out.println(dp[N - 1]);
    br.close();
  }
}



/*
dp[0] = alchol[0];
dp[1] = dp[0] + alchol[1];
dp[2] = alchol[0] + alchol[1] // alchol[0] + alchol[2] // alchol[1] + alchol[2];
dp[1] // dp[0] + alchol[2] // dp[-1] + alchol[1] + alchol[2];
dp[3] = dp[2] // dp[1] + alchol[3] // dp[0] + alchol[2] + alchol[3];*/
