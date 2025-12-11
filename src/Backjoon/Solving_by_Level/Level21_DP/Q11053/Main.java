package Backjoon.Solving_by_Level.Level21_DP.Q11053;

import java.io.*;
import java.util.*;

public class Main {
  public static int[] nums;
  public static int[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    nums = new int[N];
    dp = new int[N];		// i 번째 숫자가 반드시 들어가는 부분수열의 길이

    int maxSize = 0;

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    for(int i = 0; i < N; i++) {
      if (i == 0) {
        dp[0] = 1;
        maxSize = 1;
        continue;
      }

      int tmpMax = 0;
      int tmpIndex = 0;

      for(int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {      //
          if (dp[j] > tmpMax) {   //
            tmpMax = dp[j];
            tmpIndex = j;
          }
        }
      }

      if (tmpMax == 0) {
        dp[i] = 1;
      } else {
        dp[i] = dp[tmpIndex] + 1;
      }

      //System.out.println("Case #" + i + ": " + dp[i]);
      //System.out.println("tmpMax: " + tmpMax + ", tmpIndex: " + tmpIndex);
      maxSize = Math.max(maxSize, dp[i]);
    }

    System.out.println(maxSize);
    br.close();
  }
}

