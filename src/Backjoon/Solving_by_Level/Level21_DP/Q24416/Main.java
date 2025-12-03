package Backjoon.Solving_by_Level.Level21_DP.Q24416;

import java.io.*;
import java.util.*;

public class Main {
  public static int cnt1 = 0;
  public static int cnt2 = 0;

  public static int[] dpTable;

  public static int recursiveFib(int n) {


    if (n == 1 || n == 2) {
      cnt1++;
      return 1;
    } else {
      return (recursiveFib(n - 1) + recursiveFib(n - 2));
    }
  }

  public static int dpFib(int n) {
    dpTable[1] = 1;
    dpTable[2] = 1;

    for(int i = 3; i <= n; i++) {
      cnt2++;
      dpTable[i] = dpTable[i - 1] + dpTable[i - 2];
    }

    return dpTable[n];
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    dpTable = new int[n + 1];

    recursiveFib(n);
    dpFib(n);

    StringBuilder sb = new StringBuilder();
    sb.append(cnt1).append(" ").append(cnt2);
    System.out.println(sb);

    br.close();
  }
}
