package Backjoon.Solving_by_Level.Level31_DP2.Q7579;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] apps = new int[N + 1];
    int[] costs = new int[N + 1];

    st = new StringTokenizer(br.readLine());
    for(int i= 1; i <= N; i++) {
      apps[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for(int i= 1; i <= N; i++) {
      costs[i] = Integer.parseInt(st.nextToken());
    }

    // dp[인덱스][코스트]
    int[][] dp = new int[N + 1][10001];

    for(int i = 1; i <= N; i++) {
      for(int j = 0; j <= 10000; j++) {
        if (j - costs[i] < 0) {
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - costs[i]] + apps[i]);
        }
        /*System.out.println("dp[" + i + "][" + j + "] = " + dp[i][j]);
        System.out.println("dp[" + (i - 1) + "][" + (j - costs[i]) + "] = " + dp[i - 1][j - costs[i]]);
        System.out.println("apps[" + i + "] = " + apps[i]);*/
      }
    }

    int result = 0;
    for(int i = 0; i <= 10000; i++) {
      if (dp[N][i] >= M) {
        result = i;
        break;
      }
    }
    System.out.println(result);
  }
}